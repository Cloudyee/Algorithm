import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    //** 다이나믹 프로그래밍 메모이제이션 기법을 활용하여 풀어야한다.
    // 다이나믹 프로그래밍 : 메모이제이션 기법을 활용하여 매 문제의 답을 기억해두고 다음 문제를 풀이할 때 그 답을 참고하여 풀이
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //N은 40보다 작거나 같은 자연수 또는 0;
        int [][] arr = new int[41][2];
        //미리 0과 1이 들어올 때의 답을 저장해둔다.
        //fibo(0)이 들어오면 0이 1번 , 1이 0번
        arr[0][0] = 1;
        arr[0][1] = 0;
        //fibo(1)이 들어오면 0이 0번, 1이 1번
        arr[1][0] = 0;
        arr[1][1] = 1;

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i< T ; i++){
            int n = Integer.parseInt(br.readLine());
            for(int j = 2 ; j<=n ; j++){
                arr[j][0] = arr[j-1][0] + arr[j-2][0];
                arr[j][1] = arr[j-1][1] + arr[j-2][1];
            }
            System.out.println(arr[n][0] +" " + arr[n][1]);
        }
        
    }

//    ** 단순 재귀 : 아래 로직은 시간초과 발생
    // 단순히 매 문제마다 더 이상 풀 수 없을 때 까지 풀이하고 넘어가기 때문
//    static int one = 0 , zero = 0;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        //케이스의 개수
//        int T = Integer.parseInt(br.readLine());
//        for(int i = 0; i<T ; i++){
//            fibo(Integer.parseInt(br.readLine()));
//            System.out.println(zero+" "+ one);
//            zero = 0;
//            one = 0;
//        }
//    }
//
//    static int fibo(int i){
//        if(i == 1){
//            one++;
//            return 1;
//        }
//
//        if(i==0){
//            zero++;
//            return 0;
//        }
//
//        return fibo(i - 1) + fibo(i-2);
//    }
}
