import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int M = in.nextInt();
        int N = in.nextInt();
        //소수 배열
        int [] A = new int[N+1];

        //1은 소수가 아니므로 삭제하고 2부터 시작한다.
        for(int i = 2 ; i<=N ; i++){
            A[i] = i;
        }

        //제곱근 까지만 수행하기
        //Math.sqrt : 제곱근(루트) 구하기
        for(int i = 2 ; i<=Math.sqrt(N); i++){
            if(A[i]==0)
                continue;
            //배수 지우기
            for(int j = i+i ; j<=N ; j=j+i){
                A[j]=0;
            }
        }

        //배열에서 소수인 값 출력
        for(int i = M ; i<=N ; i++){
            if(A[i] != 0){
                System.out.println(A[i]);
            }
        }
    }

}
