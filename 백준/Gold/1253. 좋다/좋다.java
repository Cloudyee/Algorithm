import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //수의 개수
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        //N개의 입력값들을 저장할 배열
        Long[] input = new Long[N];
        for(int i = 0 ; i<N ; i++){
            input[i] = Long.parseLong(st.nextToken());
        }

        //값들을 정렬
        Arrays.sort(input);

        int count = 0;  //좋은 수의 개수

        // ** 값을 하나씩 순회하며,
        //투 포인터 알고리즘을 활용하여 문제를 해결
        for(int i = 0; i<N ; i++){
            int start = 0;
            int end = N-1;
            //좋은 수
            Long goodNum = input[i];

            while(start < end) {
                if(input[start] + input[end] == goodNum){
                    /*
                    아래와 같이, 현재의 인덱스가 좋은 수가 되어서는 안된다.
                     */
                    if(start != i && end != i){
                        count++;
                        break;
                    }else if(start == i)
                        start++;
                    else if(end==i)
                        end--;

                }else if(input[start] + input[end] < goodNum){
                    start++;
                }else{
                    end--;
                }
            }
        }
            System.out.println(count);
    }
}
