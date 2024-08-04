import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> tempAnswer = new ArrayList<>();
        int count = 0;
        
        for(int i = 0 ; i < progresses.length ; i++){
            int remain = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
            if(queue.isEmpty())
                queue.add(remain);
            
            if(queue.peek() >= remain){
                count++;
            }else if(queue.peek() < remain){
                queue.poll();
                queue.add(remain);
                tempAnswer.add(count);
                count = 1;
            }
        }
        tempAnswer.add(count);
        
        int[] answer = tempAnswer.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}