import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final int INF = 1000000 * 16 + 1;
    private static int N;
    private static int[][] W;
    private static int[][] d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine().trim());
        W = new int[16][16];
        d = new int[16][1<<16];
        for(int i = 0 ; i<N ; i++){
            st = new StringTokenizer(br.readLine().trim());
            for(int j = 0 ; j<N ; j++){
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(tsp(0,1));
    }
    //모든 경우의 수와 관련된 완전 탐새고가 재귀 구현
    private static int tsp(int c, int v){
        if(v == (1<<N)-1){
            //모든 노드를 방문할 경우
            return W[c][0] == 0 ? INF : W[c][0];
        }
        if (d[c][v] != 0){
            //이미 방문한 노드일 떄 - 바로 리턴(메모이제이션)
            return d[c][v];
        }
        int min_val = INF;
        for(int i = 0 ; i<N ; i++){
            if((v&(1<<i))==0 && W[c][i] !=0){
                //방문한 적이 ㅇ벗고, 갈 수 있는 도시일 경우
                min_val = Math.min(min_val, tsp(i,(v|(1<<i)))+W[c][i]);
            }
        }
        d[c][v] = min_val;
        return d[c][v];
    }
}
