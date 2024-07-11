import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //수의 갯수
        int M = Integer.parseInt(st.nextToken()); //합을 구해야하는 횟수

        long [] sum = new long [N+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i<=N ; i++){
            sum[i] = sum[i-1] + Long.parseLong(st.nextToken());
        }

        int start = 0;
        int end = 0;
        for(int i = 0 ; i<M ; i++){
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            System.out.println(sum[end] - sum[start - 1]);
        }
    }
}
