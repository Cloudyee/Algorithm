import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long x1  = Long.parseLong(st.nextToken());
        long y1  = Long.parseLong(st.nextToken());
        long x2  = Long.parseLong(st.nextToken());
        long y2  = Long.parseLong(st.nextToken());
        st = new StringTokenizer(br.readLine());
        long x3  = Long.parseLong(st.nextToken());
        long y3  = Long.parseLong(st.nextToken());
        long x4  = Long.parseLong(st.nextToken());
        long y4  = Long.parseLong(st.nextToken());
        
        boolean cross = isCross(x1, y1, x2, y2, x3, y3, x4, y4);
        if (cross) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    static int CCW(long x1, long y1, long x2, long y2, long x3, long y3) {
        long temp = (x1 * y2 + x2 * y3 + x3 * y1) - (x2 * y1 + x3 * y2 + x1 * y3);
        if (temp > 0) return 1;
        else if (temp < 0) return -1;
        return 0;
    }

    // 선분 겹침 여부 판별 함수
    private static boolean isOverlap(long x1, long y1, long x2, long y2, long x3, long y3, long x4, long y4) {
        if (Math.min(x1, x2) <= Math.max(x3, x4) && Math.min(x3, x4) <= Math.max(x1, x2)
                && Math.min(y1, y2) <= Math.max(y3, y4) && Math.min(y3, y4) <= Math.max(y1, y2))
            return true;
        return false;
    }

    // 선분 교차 여부 판별 함수
    private static boolean isCross(long x1, long y1, long x2, long y2, long x3, long y3, long x4, long y4) {
        int abc = CCW(x1, y1, x2, y2, x3, y3);
        int abd = CCW(x1, y1, x2, y2, x4, y4);
        int cda = CCW(x3, y3, x4, y4, x1, y1);
        int cdb = CCW(x3, y3, x4, y4, x2, y2);
        // 선분이 일직선일 때
        if (abc * abd == 0 && cda * cdb == 0) {
            return isOverlap(x1, y1, x2, y2, x3, y3, x4, y4); // 겹치는 선분인지 판별
        } else if (abc * abd <= 0 && cda * cdb <= 0) {
            // 선분이 교차하는 경우
            return true;
        }
        return false;
    }
}
