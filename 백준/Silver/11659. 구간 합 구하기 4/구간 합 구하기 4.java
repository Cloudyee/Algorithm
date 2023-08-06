import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //데이터의 갯수 입력
        int suNo = Integer.parseInt(st.nextToken());
        //질의 갯수 입력
        int quizNo = Integer.parseInt(st.nextToken());
        //구간합을 구할 대상 배열 저장용
        long[] S = new long[suNo+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i<=suNo;i++){
            //입력 받은 값들의 구간합들을 저장
            S[i] = S[i-1] + Integer.parseInt(st.nextToken());
        }
        for(int q = 0; q<quizNo;q++){
            //구간을 입력받기 위한 토크나이저
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            //구간합 출력
            System.out.println(S[j]-S[i-1]);
        }
    }
}
