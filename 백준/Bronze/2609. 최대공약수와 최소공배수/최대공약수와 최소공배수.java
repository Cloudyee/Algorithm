import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int firstNum = Integer.parseInt(st.nextToken());
        int secondNum = Integer.parseInt(st.nextToken());

        calc(firstNum , secondNum);
    }

    //최대공약수 , 최소공배수 구하기
    private  static void calc(int a, int b){
        //유클리드호제법을 활용하여 최대공약수, 최소공약수를 구한다.
        //[1] 최대공약수 구하기
        int temp = 0;
        int big = 0;
        int small = 0;
        if(a>b){
            big = a;
            small = b;
        }else{
            big = b;
            small = a;
        }

        while(small != 0){
            temp = big % small;
            big = small;
            small = temp;
        }
        //최대공약수는 big
        System.out.println(big);

        //[2] 최소공배수 구하기
        //최소공배수 = a와 b의 곱에 최대공약수를 나눈 것과 같다.
        System.out.println((a*b)/big);
    }
}
