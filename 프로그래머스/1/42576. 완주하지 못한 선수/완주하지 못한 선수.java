import java.util.*;

class Solution {
    public static String solution(String[] participant, String[] completion) {
        Map<String, Integer> temp = new HashMap<>();
        for(String key : participant){
            temp.put(key, temp.getOrDefault(key, 0)+1);
        }

        for(String removeKey : completion){
            if(temp.get(removeKey)==1){
                temp.remove(removeKey);
            }else{
                temp.put(removeKey , temp.get(removeKey)-1);
            }
        }
        String answer = temp.keySet().iterator().next();
        return answer;
    }
}