import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int result = countTrailingZeros(N);
        System.out.println(result);
    }
    /*
     * 팩토리얼 끝에 있는 0의 개수는 곱셈 결과에 10이 얼마나 많이 포함되는지에 달려 있습니다.
     * 10은 2와 5의 곱으로 이루어져 있으므로, 2와 5의 쌍을 찾아야 합니다.
     * 그러나 팩토리얼에서는 짝수(2)는 항상 많기 때문에, 5의 개수만 세어도 충분합니다.
     */
    private static int countTrailingZeros(int n) {
        int count = 0;
        while (n >= 5) {  // N을 5로 나눈 몫이 더 이상 0이 아닐 때까지 반복
            n /= 5;  // N을 5로 나눔
            count += n;  // 나눈 값을 count에 더함
        }
        return count;
    }
}
