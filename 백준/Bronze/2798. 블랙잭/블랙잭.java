import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        //카드의 개수
        int N = Integer.parseInt(st.nextToken());
        //딜러가 제시하는 숫자 (최대 숫자)
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] cards = new int[N];
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        //수를 찾기위해 정렬
        Arrays.sort(cards);

        int closeSum = 0;
        int sum;
        /*
        [브루트 포스 알고리즘]
        가능한 모든 경우의 수를 직접 계산하여 문제를 해결한다.
         */
        for(int i = 0 ; i<N-2 ; i++){
            for(int j = i+1 ; j<N-1 ; j++){
                for(int k = j+1; k<N; k++ ){
                    sum = cards[i]+cards[j]+cards[k];
                    if(sum<=M && sum>closeSum){
                        closeSum=sum;
                    }
                }
            }
        }

        System.out.println(closeSum);
    }
}
