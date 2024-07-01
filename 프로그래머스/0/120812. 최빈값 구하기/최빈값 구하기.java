class Solution {
    public int solution(int[] array) {
        int[] answer = new int[1000];
        int maxValue = 0;
        for(int idx : array){
            answer[idx]+=1;
            if(maxValue < idx)
                maxValue = idx;
        }
        
        int max = 0; 
        int result = 0;
        for(int i = 0; i<=maxValue; i++){
            if(max < answer[i]){
                max = answer[i];
                result = i;
            }else if(max == answer[i]){
                result = -1;
            }
        }
        return result;
    }
}