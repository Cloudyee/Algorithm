import java.util.*;
class Solution {
    public List<Integer>  solution(String[] intStrs, int k, int s, int l) {
        List<Integer> answer = new ArrayList<>();
        
        for(String num : intStrs){
            int ans = Integer.parseInt(num.substring(s, s+l));
            if(ans > k){
                answer.add(ans);
            }
        }       
        return answer;
    }
}