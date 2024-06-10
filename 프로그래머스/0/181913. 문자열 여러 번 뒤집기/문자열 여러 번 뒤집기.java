class Solution {
    public String solution(String my_string, int[][] queries) {
        char my[] =  my_string.toCharArray();
        for(int i = 0 ; i<queries.length ; i++){
            int start = queries[i][0];
            int end = queries[i][1];
            while(start < end){
                char temp = my[start];
                my[start] = my[end];
                my[end]= temp;
                start++;
                end--;
            }
        }
        return new String(my);
    }
}