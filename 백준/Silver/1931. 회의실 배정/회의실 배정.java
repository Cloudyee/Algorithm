import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] A= new int[N][2];
        //시작 시간과 종료시간을 저장
        for(int i = 0; i<N ; i++){
            A[i][0] = sc.nextInt();
            A[i][1] = sc.nextInt();
        }

        //이 부분 기억해두었다가 추가학습
        Arrays.sort(A, new Comparator<int[]>() {
            @Override
            public int compare(int[] S, int[] E) {
                //종료시간이 같은 경우
                if(S[1]==E[1]){
                    return S[0]-E[0];
                }
                return S[1]-E[1];
            }
        });

        int count = 0;
        int end = -1;
        for(int i = 0 ; i<N ; i++){
            //겹치지 않는 다음 회의가 나온 경우
            if(A[i][0]>=end){
                end=A[i][1];
                count++;
            }
        }
        System.out.println(count);
    }
}
