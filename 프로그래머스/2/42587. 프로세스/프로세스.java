import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<int[]> queue = new LinkedList<>();
        
        //**중요**
        //우선순위와 인덱스를 함께 저장
        for(int i = 0 ; i < priorities.length; i++){
            queue.add(new int[]{priorities[i] , i});
        }
        
        int idx = 0;
        
        while(!queue.isEmpty()){
            //가장 앞에 있는 값
            int[] now = queue.poll();
            //더 큰 수가 잇는가의 여부
            boolean hasBigger = false;
            
            for(int[] item : queue){
                if(item[0] > now[0]){
                    hasBigger = true;
                    break;
                }
            }
            
            if(hasBigger){
                //우선순위가 높은 값이 있다면 뒤로 이동
                queue.add(now);
            }else{
                //우선순위가 더 높은 값이 없을 경우
                //출력 순서 증가
                idx++;
                
                if(now[1] == location){
                    return idx; //목표 인덱스라면 출력 순서 반환
                }
            }
        }
        return -1; // 모든 조건을 다 고려했지만 여기에 도달할 일은 없음
    }
}