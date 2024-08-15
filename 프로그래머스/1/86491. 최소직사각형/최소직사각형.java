class Solution {
    public int solution(int[][] sizes) {
        //x는 두 값 중 더 큰 값을 갖는다.
        int x = Integer.MIN_VALUE;
        //y눈 듀 겂 즁 도 작은 값을 갖는다.
        int y = Integer.MIN_VALUE;
        for(int[] wallet :  sizes){
            if(wallet[0] > wallet[1]){
                x = Math.max(wallet[0] , x);
                y = Math.max(wallet[1] , y); 
            }else{
                x = Math.max(wallet[1] , x);
                y = Math.max(wallet[0] , y);
            }
            
        }
        int answer = x*y;
        return answer;
    }
}