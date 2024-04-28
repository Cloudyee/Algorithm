import java.util.Scanner;

public class Main {
    static int N, K;
    static int[][] D;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        D = new int[N+1][N+1];
        for(int i = 0 ; i<=N ; i++){
            D[i][1] = i; //i개 중 1개를 뽑는 경우의 수는 i개
            D[i][0] = 1; //i게 중 1개도 선택하지 않는 경우의 수는 1개
            D[i][i] = 1; //i개 중 i개를 뽑는 경우의 수는 1개
        }
        for(int i =2 ; i<= N ; i++){
            for(int j = 1; j<i ; j++){
                D[i][j] = D[i-1][j] + D[i-1][j-1]; // 기본 조합 점화식
            }
        }
        System.out.println(D[N][K]);
    }
}
