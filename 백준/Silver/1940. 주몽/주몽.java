import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        //입력 받을 갯수
        int N = Integer.parseInt(bf.readLine());
        //도출할 합의 값
        int M = Integer.parseInt(bf.readLine());

        //입력값들 저장
        int [] A = new int [N];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i = 0 ; i<N; i++){
            A[i]=Integer.parseInt(st.nextToken());
        }
        //오름차순 정렬
        Arrays.sort(A);

        //경우의 수
        int count = 0;
        int i = 0;
        int j = N-1;

        //투 포인터
        while(i<j){
            if(A[i]+A[j]<M){
                i++;
            }else if(A[i]+A[j]>M){
                j--;
            }else{
                count++;
                i++;
                j--;
            }
        }
        System.out.println(count);
        bf.close();
    }
}
