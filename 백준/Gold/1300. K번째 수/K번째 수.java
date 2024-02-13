import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        long start = 1, end = K;
        long result = 0;
        
        //이진 탐색 수행
        while(start<=end){
            long middle =(start+end)/2;
            long count = 0;
            //중앙값보다 작은 수가 몇개인지 계산
            for(int i = 1; i<=N ; i++){
                //작은 수를 카운트하는 해심 로직
                //나눈 값이 N보다 크다면 작은 수는 N이여야하므로 아래와같이 작성
                count+=Math.min(middle/i, N);
            }
            if(count<K){
                start = middle+1;
            }else{
                //현재 단계의 중앙갓을 정답 변수에 저장
                result=middle;
                end=middle-1;
            }
        }
        System.out.println(result);
    }
}
