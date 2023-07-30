import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //받은 값 공백 기준으로 분리
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        //N과 M 받아 저장
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int [][] A = new int [N][M];
        int [][] B = new int [N][M];
        int [][] result = new int[N][M];

        StringBuilder sb = new StringBuilder();

        //첫 번째 입력 값 저장
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0 ; j<M; j++){
                A [i][j]=Integer.parseInt(st.nextToken());
            }
        }

        //두 번째 입력 값 저장
        for(int i=0; i<N ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j =0; j<M ; j++){
                B [i][j]=Integer.parseInt(st.nextToken());
            }
        }

        //두가지 값들을 저장할 배열
        for(int i=0; i<N ; i++){
            for(int j =0; j<M ; j++){
                result [i][j]=A[i][j]+B[i][j];
                System.out.print(result[i][j]+ " ");
            }
            System.out.println();
        }

    }
}
