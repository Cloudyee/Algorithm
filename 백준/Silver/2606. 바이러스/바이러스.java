import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int computers = Integer.parseInt(br.readLine());
        int ssang = Integer.parseInt(br.readLine());

        StringTokenizer st;
        //컴퓨터들의 값을 저장할 배열
        //해당 배열의 값이 1일경우를, 각 컴퓨터들이 연결되어있는 경우로 판단할 것임.
        int [][] networks = new int[computers][computers];
        boolean [] visited = new boolean[computers];    //탐색 완료 여부

        int x;
        int y;
        //컴퓨터 씽을 입력받는다.
        for(int i = 0 ; i<ssang ; i++){
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken()) -1;
            y = Integer.parseInt(st.nextToken()) -1;
            //**무방향 그래프이므로, 양방향으로 갑 ㅅ저장 필요
            networks[x][y] = 1;
            networks[y][x] = 1;
        }

        //[중요] 빼먹었던 부분 ******
        //0 = 컴퓨터 1
        int count = bfs(visited, networks , 0);

        //**아래의 방식은 모든 경우의수를 탐색한다.
        //하지만 우리는 '1번 컴퓨터를 통해' 웜 바이러스에 걸리는 컴퓨터의 수를 출력하면 됨
        //따라서, 해당 부분은 불필요
//        //웜 바이러스에 걸리는 컴퓨터 수를 탐색
//        for(int i = 0 ; i<computers ; i++){
//            //아직 방문하지 않은 컴퓨터의 경우
//            // bfs탐색 실시
//            if(visited[i] != true){
//                count++;
//                bfs(visited, networks , i);
//            }
//        }

        System.out.println(count);
    }

    private static int bfs(boolean visited[] , int networks[][] , int x ){
        Queue<Integer> queue = new LinkedList<>();
        visited[x] = true;
        queue.add(x);

        int count = 0;

        while(!queue.isEmpty()){
            int nowPosition = queue.poll();

            for (int i = 0 ; i<visited.length ; i++){
                //탐색용 인덱스가 현재의 위치(인덱스)가 아니고,
                //해당 인덱스를 아직 방문하지 않았으며
                //네트워크의 현재위치의 인덱스 부분이 1일 경우
                //즉 연결된 컴퓨터인 경우
                if( nowPosition != i && !visited[i]
                && networks[nowPosition][i] == 1){
                    visited[i] = true;
                    count++;
                    queue.add(i);
                }
            }
        }
        return count;
    }

}
