import java.util.Scanner;

public class Main {
    static int N; //구하고자 하는 수
    static int D[]; //D[i] : i에서 1로 만드는 데 걸리는 최소 연산 횟수

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        N = sc.nextInt();
        D = new int[N+1];
        D[1] = 0; //1일 때는 연산 불필요
        for(int i = 2 ; i<=N ; i++){
            D[i] = D[i-1]+1;//-1 연산 표현
            if(i%2==0)D[i] = Math.min(D[i], D[i/2]+1);
            if(i%3==0)D[i] = Math.min(D[i], D[i/3]+1);
            //1을 더하는 것은 연산 횟수를 나타내기 위함이다.
        }
        System.out.println(D[N]);
    }
}
