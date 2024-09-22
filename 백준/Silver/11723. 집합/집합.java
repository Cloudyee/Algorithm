import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //수행해야하는 연산의 수
        //****일반적인 자료구조만 사용하면 시간초과 발생...
        //비트 마스킹 개념을 활용한다. (나는...헷갈린다)
        int M = Integer.parseInt(br.readLine());

        int S = 0;//비트 마스킹을 위한 정수
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < M; i++) {
           StringTokenizer st;
            while (M-- > 0) {
                st = new StringTokenizer(br.readLine());
                String str = st.nextToken();
                if (str.equals("all")) S = (1 << 21) - 1;
                else if (str.equals("empty")) S = 0;
                else {
                    int num = Integer.parseInt(st.nextToken());
                    if (str.equals("add"))
                        S |= (1 << num);
                    else if (str.equals("remove"))
                        S &= ~(1 << num);
                    else if (str.equals("check"))
                        sb.append((S & (1 << num)) != 0 ? 1 : 0).append("\n");
                    else if (str.equals("toggle"))
                        S ^= (1 << num);
                }
            }
            System.out.println(sb);
        }
    }
}