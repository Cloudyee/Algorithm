import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long mod = 1000000000;
        long D[] = new long[1000001]; //N명일때 선물을 교환할 수 잇는 모든 경우의 수
        D[1] = 0; //혼자서는 선물을 교환할 수 없다.
        D[2] = 1; //2명일 경우에는 서로 교환하는 경우의 수만 존재한다.
        for(int i = 3 ; i<= N ; i++){
            //i명이 교환할 수 있는 모든 경우의 수
            D[i] = (i-1)*(D[i-1]+D[i-2])%mod;//완전 순열 점화식
        }
        System.out.print(D[N]);
    }
}
