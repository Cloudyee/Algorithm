import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        while (testCases-- > 0) {
            long target = sc.nextLong();
            int count = 0;

            for (long k = 2; k * (k + 1) / 2 <= target; k++) {
                if ((target - k * (k + 1) / 2) % k == 0) {
                    count++;
                }
            }

            System.out.println(count);
        }
    }
}
