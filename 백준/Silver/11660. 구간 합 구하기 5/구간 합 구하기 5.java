import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //표의 크기
        int N = Integer.parseInt(st.nextToken());
        //합을 구해야하는 횟수
        int M = Integer.parseInt(st.nextToken());
        //기본 표
        int [][] basic = new int[N+1][N+1];
        //구간 합 배열
        int [][] hap = new int[N+1][N+1];
        //표에 채워져있는 수
        for(int i = 1; i<=N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j<=N ; j++){
                basic[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //구간합 구하기
        for(int i = 1; i<=N ; i++){
            for(int j = 1; j<=N ; j++){
                //구해야할 구간합의 직전 값의 합 - 중복하여 더해진 값 + 기준이 되는 기본 값
                hap[i][j] = hap[i][j-1]+hap[i-1][j] - hap[i-1][j-1] + basic[i][j];
            }
        }
        
        //구해야할 값 답변하기
        for(int i = 0 ; i<M ; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int result = hap[x2][y2] - hap[x1-1][y2] - hap[x2][y1-1] + hap[x1-1][y1-1];
            System.out.println(result);
        }
    }
}
