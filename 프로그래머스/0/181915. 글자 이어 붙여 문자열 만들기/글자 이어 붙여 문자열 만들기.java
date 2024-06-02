class Solution {
    public String solution(String my_string, int[] index_list) {
        String answer = "";
        char string [] = my_string.toCharArray();
        for(int index : index_list){
            answer += string [index];
        }
        return answer;
    }
}