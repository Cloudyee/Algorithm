class Solution {
    public String solution(String my_string, int s, int e) {
        String answer = my_string.substring(s, e+1);
        StringBuffer buffer = new StringBuffer(answer);
        
        return my_string.substring(0,s)
            +buffer.reverse().toString()
            +my_string.substring(e+1 , my_string.length());
    }
}