import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //입력받을 수의 개수
        int N = Integer.parseInt(st.nextToken());
        //나눌 값
        int M = Integer.parseInt(st.nextToken());
        //구간합 배열
        long[] sum = new long[N];
        //구간합 % M 배열 : 인덱스 = 나머지 값의 갯수
        long[] remain = new long[M];

        long answer = 0;
        
        st = new StringTokenizer(br.readLine());
        sum[0] = Long.parseLong(st.nextToken());
        //구간합 저장
        for(int i = 1 ; i<N ; i++){
            sum[i] = sum[i-1] + Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i<N ; i++){
            int remainder = (int) (sum[i] % M);
            //0~i까지 구간합 자체가 0일때 정답에 더하기
            if(remainder == 0)
                answer++;
            remain[remainder]++;
        }

        for(int i = 0 ; i<M ; i++){
            if(remain[i] > 1){
                //나머지가 같은 인덱스 중 2개를 뽑는 경우의 수를 더하기
                // -> 위에서 0을 더해주는것이 중복이 되지 않는가?
                // => 그렇지 않다. 위의 수를 더해준 것은 0인덱스부터 자신의 인덱스까지의 합 % M이 나누어떨어지는 경우를 더한것.
                // 지금의 경우는 나머지가 같은 인덱스 중 2가지를 뽑는 경우의 수를 더한 것.

                //아래 식은 조합의 식 n*(n-1)/2
                answer = answer+ (remain[i] * (remain[i]-1))/2;
            }
        }
        System.out.println(answer);
    }
}
