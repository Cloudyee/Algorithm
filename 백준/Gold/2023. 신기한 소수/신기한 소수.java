import java.util.Scanner;

public class Main {
    //자릿 수
    static int N;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();

        //일의 자리 소수는 2, 3, 5, 7이므로 4개의 수에서만 시작!
        DFS(2,1);
        DFS(3,1);
        DFS(5,1);
        DFS(7,1);
    }
    //DFS 함수 구현
    static void DFS(int number , int jarisu){

        if(jarisu ==N ){
            if(isPrime(number)){
                System.out.println(number);
            }
            return;
        }
        //짝수라면 더이상 탐색할 필요 없음
        for (int i = 1 ; i<10 ; i++){
            if(i%2 == 0){
                continue;
            }
            //소수라면 재귀함수로 자릿수를 늘려준다.
            if(isPrime(number*10 + i )){
                DFS(number*10+i, jarisu+1);
            }
        }
    }

    static boolean isPrime(int num){
        for(int i =2 ; i<=num/2 ; i++){
            if(num%i == 0)
                return false;
        }
        return true;
    }
}
