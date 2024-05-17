class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        int gop=1;;
        int hop=0;
        for(int i = 0; i<num_list.length ; i++){
            gop*=num_list[i];
            hop+=num_list[i];
        }
        return answer=gop<Math.pow(hop,2)?1:0;
    }
}