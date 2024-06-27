class Solution {
    public int[] solution(String my_string) {
        int[] answer = new int[52]; // 26 for 'A'-'Z' and 26 for 'a'-'z'

        for (int i = 0; i < my_string.length(); i++) {
            char ch = my_string.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                answer[ch - 'A'] += 1; // 'A'-'Z' are mapped to 0-25
            } else if (ch >= 'a' && ch <= 'z') {
                answer[ch - 'a' + 26] += 1; // 'a'-'z' are mapped to 26-51
            }
        }
        
        return answer;
    }
}
