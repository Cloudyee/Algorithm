class Solution {
    public String solution(String my_string, int[] indices) {
        String[] myString = my_string.split("");
        String answer = "";
        for(int index :indices ){
            myString[index]="";     
        }
        answer = String.join("", myString);
        return answer;
    }
}