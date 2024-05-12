import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long D[][] = new long[N + 1][2];
        D[1][1] = 1; //1자리 1 이친수는 한가지
        D[1][0] = 0; //1자리 0 이친수는 없음
        for (int i = 2; i <= N; i++) {
            D[i][0] = D[i - 1][1] + D[i - 1][0]; //i번째 0으로 끝나는 개수
            //1은 이전단계의 0으로 끝나는 경우만 붙일 수 있다.
            D[i][1] = D[i - 1][0]; //i번째 1로 끝나는 개수
        }
        System.out.println(D[N][0] + D[N][1]);
    }
}
