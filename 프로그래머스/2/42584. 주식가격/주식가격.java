import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        //Stack을 활용하여 풀이해본다.
        int[] answer = new int[prices.length];
        //가격의 '인덱스'를 담을 스택
        //**해당 부분을 스스로 구상할 수 있어야 한다...
        Stack<Integer> stack = new Stack<>();
        
        //가격 배열(prices)을 순회하며 연산 수행
        for(int i = 0 ; i<prices.length ; i++){
            //스택이 비어있지 않고 && 스택의 맨 위 인덱스 가격이 현재 가격보다클 경우
            // 즉, 이전의 가격보다 현재의 가격이 더 클경우 = 가격이 내린 경우
            while(!stack.isEmpty() && prices[stack.peek()] > prices[i]){
                int index = stack.pop();
                //가격이 떨어진 시점까지의 시간을 계산하여 결과에 저장
                answer[index] = i - index;
            }
         
            //현재 인덱스를 스택에 추가
            stack.push(i);
        }
        
        //스택에 마지막까지 남아있는 인덱스 처리(끝까지 가격이 떨어지지 X)
        while(!stack.isEmpty()){
            int index = stack.pop();
            answer[index] = prices.length - 1 - index;
        }
        
        return answer;
    }
}