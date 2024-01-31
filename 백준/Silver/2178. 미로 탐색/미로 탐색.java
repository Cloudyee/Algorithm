import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    //상하좌우 탐색을 위한 배열 선언
    static int[]dx= {0,1,0,-1};
    static int[]dy = {1,0,-1,0};

    //탐색 여부 저장
    static boolean [][] visited;

    static int[][] A;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        A=new int [N][M];
        visited=new boolean[N][M];

        for(int i = 0 ; i<N; i++){
            st=new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for(int j = 0 ; j<M ; j++){
                A[i][j]=Integer.parseInt(line.substring(j, j+1));
            }
        }
        //0,0에서 시작
        BFS(0,0);
        System.out.println(A[N-1][M-1]);
    }

    public static void BFS(int i , int j){
        Queue<int[]> queue = new LinkedList<>();
        //시작 노드 삽입
        queue.offer(new int[]{i,j});
        //현재 노드 방문 기록
        visited[i][j]=true;
        
        //큐가 비어있을 때 까지 반복
        while(!queue.isEmpty()){
            //큐에서 노드 데이터를 가져온다.
            int now[] = queue.poll();
            //상하좌우를 탐색
            for(int k = 0 ; k<4 ; k++){
                int x = now[0]+dx[k];
                int y = now[1]+dy[k];
                //좌표 유효성 검사
                if(x>=0 && y>=0 && x<N && y<M){
                    //갈수 있는 칸인지 여부 , 방문 여부 검사
                    if(A[x][y]!=0 && !visited[x][y]){
                        visited[x][y]=true;
                        //깊이 업데이트
                        A[x][y]=A[now[0]][now[1]]+1;
                        queue.add(new int[]{x,y});
                    }
                }
            }
        }
    }
}
