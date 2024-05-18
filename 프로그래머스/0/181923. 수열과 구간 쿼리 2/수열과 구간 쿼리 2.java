class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];
        int cnt = 0;
        
        for(int [] querie : queries){
            int s = querie[0];
            int e = querie[1];
            int k = querie[2];
            int minNum = Integer.MAX_VALUE;
            
            for(int i = s; i<=e ; i++){
                if(arr[i]>k && arr[i] <minNum){
                    minNum = arr[i];
                }
            }
            if(minNum != Integer.MAX_VALUE){
                answer[cnt]=minNum;
            }else{
                answer[cnt]=-1;
            }
            cnt++;
        }
        
        return answer;
    }
}