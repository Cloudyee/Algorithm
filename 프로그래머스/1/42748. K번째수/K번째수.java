import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        
        int[] answer = new int[commands.length];
        List<Integer> tmp = new ArrayList<>();
       
        for(int i = 0; i < commands.length ; i++){
            int end = commands[i][1];
            
            for(int start= commands[i][0]; start <= end; start++){
                tmp.add(array[start-1]);
            }
            
            Collections.sort(tmp);
            answer[i] = tmp.get(commands[i][2]-1);
            tmp.clear();
        }
        
        return answer;
    }
}