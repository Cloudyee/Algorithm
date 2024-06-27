class Solution {
    public int solution(String my_string, String is_prefix) {
        String temp = "";
        int answer = 0;
        for(int i = 0 ; i<my_string.length() ; i++){
            temp +=my_string.charAt(i);
            
            if(is_prefix.equals(temp)){
                answer = 1;
            }
        }
        return answer;
    }
}