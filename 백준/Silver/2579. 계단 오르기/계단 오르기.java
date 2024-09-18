import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static Integer [] dp;
    private static int [] scores;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int stairs = Integer.parseInt(br.readLine());
        scores = new int [stairs+1];
        dp = new Integer [stairs+1];

        for(int i = 1 ; i <= stairs ; i++){
            //각 계단의 점수
            scores[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = scores[0];
        dp[1] = scores[1];

        //2일 경우 : dp에 누적합 더하기
        // 마지막 계단은 **반드시** 밟아야 한다.
        if(stairs >= 2){
            dp[2] = scores[1] + scores[2];
        }

        //[1] Top-Down 방식
//        for(int i = 3 ; i <= stairs ; i++){
//            dp[i] = Math.max(dp[i-2], dp[i-3]+scores[i-1]) + scores[i];
//        }
//
//        System.out.println(dp[stairs]);
        //[2] Bottom-up 방식
        //이후 값들은 동적계산법을 통해 계산해준다.
        System.out.println(find(stairs));
    }

    static int find( int stairs){
        //아직 탐색하지 않은 계단일 경우
        if(dp[stairs] == null){
            //재귀적으로 호출
            dp[stairs] = Math.max(find(stairs-2) , find(stairs-3) + scores[stairs-1])+ scores[stairs];
        }

        return dp[stairs];
    }

}
