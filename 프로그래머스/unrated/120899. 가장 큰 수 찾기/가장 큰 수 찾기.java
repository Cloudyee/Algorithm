class Solution {
    public int[] solution(int[] array) {
        int[] answer = new int [2];
        int count = 0;
        int maxNum = 1;
        for(int i=0; i<array.length ; i++){
            if(array[i]>=maxNum){
                maxNum=array[i];
                answer[0] = maxNum;
                answer[1] = i;
            }
        }
        return answer;
    }
}