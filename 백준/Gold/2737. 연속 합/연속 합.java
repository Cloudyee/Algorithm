import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt(); // 테스트 케이스의 개수
        while (T-- > 0) {
            double n = sc.nextDouble(); // 입력받은 수

            // k의 최댓값을 계산
            double lim = (-1 + Math.sqrt(8 * n + 1)) / 2;

            int ans = 0; // 결과 초기화
            for (double k = 2; k <= lim; k++) {
                // 연속된 자연수의 합을 계산
                double a = -(k / 2) + 0.5 + (n / k);
                
                // a가 정수인지 확인하여 결과 증가
                if (a == (int) a) {
                    ans++;
                }
            }

            System.out.println(ans); // 결과 출력
        }
    }
}
