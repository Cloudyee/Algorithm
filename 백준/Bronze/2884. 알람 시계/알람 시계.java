import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int hour = Integer.parseInt(st.nextToken());
        int min = Integer.parseInt(st.nextToken());

        int nowTime = hour * 60 + min;
        int earlyTime = nowTime - 45;

        if (earlyTime < 0) {
            earlyTime += 24 * 60; // 음수 시간 처리
        }

        int earlycalcHour = earlyTime / 60;
        int earlycalcMin = earlyTime % 60;

        System.out.println(earlycalcHour + " " + earlycalcMin);
    }
}
