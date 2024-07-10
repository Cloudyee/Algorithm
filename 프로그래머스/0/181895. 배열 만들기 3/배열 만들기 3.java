import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[][] intervals) {
        List<Integer> result = new ArrayList<>();
        for(int i = 0 ; i<2 ; i++){
            int start = intervals[i][0];
            int end = intervals[i][1];
            for(int j = start ; j<=end ; j++){
                result.add(arr[j]);
            }
        }
        int[]  answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }        
        return answer;
    }
}