import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int len = nums.length/2;
        int answer = len;
        
        int [] ansList  = Arrays.stream(nums).distinct().toArray();
       
        if(len > ansList.length)
            answer = ansList.length;
        
        return answer;
    }
}