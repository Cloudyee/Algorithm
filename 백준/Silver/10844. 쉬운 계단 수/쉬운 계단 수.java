import java.util.Scanner;

public class Main {
    static long mod = 1000000000;

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int N = sc.nextInt();
        long D[][] = new long[N+1][11];
        //숫자가 0으로 시작할 수 없으므로 D[0][1]은 0으로 초기화 한다.

        //길이가 1일 때 만드는 높이 H로 끝나는 계단 수의 모든 경우의 수는 1
        for(int i = 1 ; i<=9 ; i++){
            D[1][i] = 1;
        }
        for(int i = 2 ; i<=N ; i++){
            //N에서 높이가 0이면 N-1에서 높이가 1이여야 계단 수가 가능
            D[i][0] = D[i-1][1];
            //N에서 높이가 9이면 N-1에서 높이가 8이여야 계단 수가 가능
            D[i][9] = D[i-1][8];

            for(int j = 1 ; j<=8 ; j++){
                D[i][j] = (D[i-1][j-1]+D[i-1][j+1])%mod;
            }
        }

        long sum = 0;
        for(int i = 0; i<10 ; i++){
            sum = (sum+D[N][i]) % mod;
        }
        System.out.println(sum);
    }
}
