import java.util.*;

class Solution {
    public int[] solution(int l, int r) {
        List<Integer> results = new ArrayList<>();
        
        //BFS를 사용하여 0과 5로만 이루어진 숫자를 생성한다.
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        queue.add(5);
        while(!queue.isEmpty()){
            //queue의 맨 앞의 값 반환 후 삭제
            int num = queue.poll();
            
            //num이 0인 경우는 넘기고, 범위 내에 있는 숫자만 리스트에 추가한다.
            if(num!=0 && num>=l && num<=r){
                results.add(num);
            }
            
            //num*10+0과 num*10+5를 큐에 추가
            if(num!=0){
                int nextNum1 = num*10;
                int nextNum2 = nextNum1+5;
                
                if(nextNum1<=r) queue.add(nextNum1);
                if(nextNum2<=r) queue.add(nextNum2);
            }
        }
        
        if(results.isEmpty())
            return new int[]{-1};
        
        //결과를 오름차순으로 정렬한 후 배열로 변환
        Collections.sort(results);
        return results.stream().mapToInt(i->i).toArray();
    }
}


//-----------------------------------
//다른분의 정말 멋진 풀이
// class Solution {
//     public int[] solution(int l, int r) {

//         ArrayList<Integer> list = new ArrayList<>();

//         for (int i = 1; i < 64; i++) {
//             int num = Integer.parseInt(Integer.toBinaryString(i)) * 5;
//             if (l <= num && num <= r)
//                 list.add(num);
//         }

//         return list.isEmpty() ? new int[] { -1 } : list.stream().mapToInt(i -> i).toArray();
//     }
// }