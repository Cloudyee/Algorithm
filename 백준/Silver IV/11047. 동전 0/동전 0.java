import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ///동전 수
        int N = sc.nextInt();
        //목표금액
        int K = sc.nextInt();
        //동전의 값
        int [] A = new int [N];
        for(int i = 0 ; i<N ; i++){
            A[i]=sc.nextInt();
        }

        int count = 0;
        for(int i = N-1 ; i>=0 ; i--){
            //현재 동전의 가치가 K보다 작거나 같으면 구성에 추가
            if(A[i]<=K) {
                count+=(K/A[i]);
                //K를 현재 동전을 사용하고 남은 값으로 갱신
                K=K%A[i];
            }
        }
        System.out.println(count);
    }
}
