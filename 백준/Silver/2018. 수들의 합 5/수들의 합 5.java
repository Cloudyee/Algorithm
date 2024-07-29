import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 투 포인터 개념을 활용히여 문제를 풀이한다.
         * 반드시 개념을 숙지할 것
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        //가지수 ** 입력 값 자체의 경우의 수를 포함한 상태로 진행
        int count = 1;
        //시작 인덱스
        int start = 1;
        //끝 인덱스
        int end = 1;

        //합
        int sum = 1;

        while(end != N){
            if(sum == N){
                //현재 연속합이 N과 같은 경우
                count++;
                end++;
                sum += end;
            }else if(sum > N){
                /*
                    현재 연속합이 N보다 클 경우
                    => 시작 인덱스의 수를 키운다.
                    == 앞의 수를 버리고 합을 구한다.
                    해당 합을 기준으로 다시 계산
                 */
                sum -= start;
                start++;
            }else if(sum < N){
                //현재의 합이 N보다 작은 경우
                end++;
                sum += end;
            }
        }

        System.out.println(count);
    }
}
