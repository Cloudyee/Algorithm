class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = arr.clone();
        int temp;
        for(int i = 0 ; i<queries.length ; i++){
                int first = queries[i][0];
                int second = queries[i][1];
                temp = answer[first];
                answer[first] = answer[second];
                answer[second] = temp;
        }
        return answer;
    }
}