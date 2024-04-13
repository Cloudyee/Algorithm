import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M;
    static int distance[][];

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        //유저 수
        N = Integer.parseInt(st.nextToken());
        //친구 관계 수
        M = Integer.parseInt(st.nextToken());
        //유저가 1부터 싲가하므로 N+1
        distance= new int[N+1][N+1];
        //인접행렬 초기화 (위와 마찬가지의 이유)
        for(int i = 1 ; i<=N ; i++){
            for(int j = 1 ; j<=N ; j++){
                if(i==j)
                    distance[i][j]=0;
                else
                    //충분히 큰 수로 저장
                    distance[i][j] = 1000001;
            }
        }

        //친구관계이므로 양방향 저장을 하며 1로 가중치를 통일
        for(int i = 0 ; i<M ; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            distance[s][e] = 1;
            distance[e][s] = 1;
        }

        //플로이ㄷ-워셜 알고리즘 수행
        for(int k = 1 ; k<=N ; k++){
            for(int i = 1 ; i<=N ; i++){
                for(int j = 1; j<=N ; j++){
                    if(distance[i][j] > distance[i][k]+distance[k][j])
                        distance[i][j] = distance[i][k]+distance[k][j];
                }
            }
        }
        int Min = Integer.MAX_VALUE;
        int Answer = -1;
        for (int i = 1; i<=N ; i++){
            int temp = 0;
            for(int j = 1 ; j<=N ; j++){
                temp = temp+distance[i][j];
            }
            //가장 작은 케빈 베이컨의 수를 지니고 있는 i를 찾기
            if(Min >temp){
                Min = temp;
                Answer = i;
            }
        }
        System.out.println(Answer);
    }
}
