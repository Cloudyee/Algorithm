import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        
        int answer = 0;
        
        //[1] 우선순위 큐를 사용한다.
        // 각 요소가 우선순위에 따라 정렬되어 큐에 저장된다.
        
        //스코빌 지수를 저장할 우선순위 큐
        PriorityQueue<Integer> pqScoville = new PriorityQueue<>();
        
        //[2] 스코빌 지수를 우선순위 큐에 저장
        for(int sc : scoville)
            pqScoville.add(sc);
        
        //[3] 우선 순위 큐의 크기가 1보다 클 동안 반복
        while(pqScoville.size() > 1){
            //[3-1]가장 작은 스코빌 지수가 K 이상이라면 횟수 반환
            if(pqScoville.peek() >= K)
                return answer;
            
            //[3-2]스코빌 지수가 가장 낮은 음식을 꺼내 계산
            int first = pqScoville.poll();
            int second = pqScoville.poll();
            pqScoville.add(first + second*2);
            
            answer++;
        }
        
        //마지막 남은 음식이 K 이상인지 확인
        if(pqScoville.peek() >= K)
            return answer;
        
        //조건에 맞는 경우가 없다면 -1 반환
        return -1;
    }
}