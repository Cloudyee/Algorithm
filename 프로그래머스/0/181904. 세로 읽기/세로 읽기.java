class Solution {
    public String solution(String my_string, int m, int c) {
        int y  = my_string.length()/m;
        String answer = "";
        String result[][] = new String[y][m];
        int index = 0;

        for(int i = 0 ; i<y ; i++){
            for(int j = 0 ; j<m; j++){
                result[i][j] = my_string.charAt(index)+"";
                index++;
                }
            }

            for(int i = 0 ; i< y ; i++){
                answer+=result[i][c-1];
            }
            return answer;
    }
}