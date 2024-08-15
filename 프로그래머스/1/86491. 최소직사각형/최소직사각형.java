class Solution {
    public int solution(int[][] sizes) {
        //x는 두 값 중 더 큰 값을 갖는다.
        int x = Integer.MIN_VALUE;
        //y는 두 값 중 더 작은 값을 갖는다.
        int y = Integer.MIN_VALUE;
        for(int[] wallet :  sizes){
            // if(wallet[0] > wallet[1]){
            //     x = Math.max(wallet[0] , x);
            //     y = Math.max(wallet[1] , y); 
            // }else{
            //     x = Math.max(wallet[1] , x);
            //     y = Math.max(wallet[0] , y);
            // }
            
            //아래는 다른 사람들 것을 참고하여 더 최적화한 것
            x = Math.max(Math.max(wallet[0], wallet[1]), x);
            y = Math.max(Math.min(wallet[0], wallet[1]), y);
        }
        int answer = x*y;
        return answer;
    }
}