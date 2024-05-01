import java.util.Scanner;

public class Main {
    static int T, N, K;
    static int[][] D;

    public static void main(String[] args) {
        D = new int[15][15]; //n이 최대 14이기 때문
        for(int i = 0; i<15 ; i++){
            D[i][1]=1; //i층의 1호는 늘 1
            D[0][i]=i; //0층의 i호는 늘 i
        }
        for(int i = 1; i<15 ; i++){
            for(int j = 2 ; j<15 ; j++){
                D[i][j] = D[i][j-1]+D[i-1][j]; //점화식
            }
        }

        Scanner sc = new Scanner(System.in);
        T = sc.nextInt(); //질의 수
        for(int i = 0; i<T ; i++){
            K = sc.nextInt();
            N = sc.nextInt();
            System.out.println(D[K][N]);
        }
    }
}
