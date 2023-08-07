import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //수의 개수 N
        int N = Integer.parseInt(br.readLine());
        //좋은 수의 갯수
        int Result = 0;
        //수 저장 배열
        long A[] = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        //입력 받은 수를 배열에 저장
        for(int i = 0; i<N;i++){
            A[i] = Long.parseLong(st.nextToken());
        }
        //입력받은 값을 정렬
        Arrays.sort(A);

        for(int k =0; k<N; k++){
            {
                //좋은 숫자를 찾기 위한 k
                long find = A[k];
                int i = 0;
                int j = N - 1;

                //투 포인터 알고리즘
                while (i < j) {
                    if (A[i] + A[j] == find){
                        //find는 서로 다른 두 수의 합이어야 한다.
                        if(i!=k && j!=k){
                            Result++;
                            break;
                        } else if(i==k){
                            i++;
                        } else if (j==k){
                            j--;
                        }
                    }else if(A[i] + A[j] < find){
                        i++;
                    }else{
                        j--;
                    }
                }
            }
        }
        System.out.println(Result);
        br.close();
    }
}
