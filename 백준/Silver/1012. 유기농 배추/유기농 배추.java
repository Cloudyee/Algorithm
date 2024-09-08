import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    //유기농 배추 문제
    private static int xMove[] = {0, 1, 0, -1};
    private static int yMove[] = {-1, 0, 1, 0};
    private static boolean visited[][];
    private static int M;
    private static int N;
    private static int [][] farm;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //테스트 케이스의 개수
        int T = Integer.parseInt(br.readLine());
        
        //테스트 케이스만큼 반복 실행
        for(int tc = 0 ; tc< T ; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            //배추밭의 가로 길이
            M = Integer.parseInt(st.nextToken());
            //배추밭의 세로길이
            N = Integer.parseInt(st.nextToken());
            //배추가 심어져있는 위치의 개수
            int K = Integer.parseInt(st.nextToken());
            //방문여부
            visited = new boolean[M][N];
            //밭에 필요한 지렁이
            int count = 0;

            //밭
            farm = new int[M][N];

            //배추의 가로, 세로 위치
            int x, y;

            //배추의 위치 저장
            for(int i = 0 ; i<K ; i++){
                st = new StringTokenizer(br.readLine());
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                farm[x][y] = 1;
            }


            for(int i = 0 ; i<M; i++){
                for(int j = 0 ; j<N ; j++){
                    if(!visited[i][j] && farm[i][j] == 1){
                        count++;
                        //BFS 방식으로 탐색
                        bfs( i , j);
                    }
                }
            }

            System.out.println(count);
        }
    }

    private static void bfs( int x , int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        int temp[];

        while(!queue.isEmpty()){
            temp = queue.poll();
            //상하좌우를 돌면서 탐색
            for(int i = 0 ; i<4 ; i++){
                int bfsX = temp[0]+ xMove[i];
                int bfsY = temp[1] + yMove[i];

                if(bfsX < M && bfsY < N && bfsX >=0 && bfsY >=0){
                    if(!visited[bfsX][bfsY] && farm[bfsX][bfsY] == 1){
                        queue.add(new int[] {bfsX, bfsY});
                        visited[bfsX][bfsY] = true;
                    }
                }
            }
        }
    }

    //dfs방식으로 구현할 경우
    private static void dfs(int x, int y){
        visited[x][y] = true;

        //4바퀴를 선회하며 탐색
        for(int i = 0 ; i<4 ; i++){
            int dfsX = x + xMove[i];
            int dfsY = y + yMove[i];

            if(dfsX >= 0 && dfsY >= 0 && dfsX < M && dfsY < N){
                if(!visited[dfsX][dfsY] && farm[dfsX][dfsY] == 1){
                    visited[dfsX][dfsY] = true;
                    dfs(dfsX , dfsY);
                }
            }
        }
    }

}
