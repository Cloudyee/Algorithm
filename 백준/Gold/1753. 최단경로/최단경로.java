import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    //각각 노드, 에지의 개수, 출발 노드
    public static int V,E,K;
    //거리 배열
    public static int distance[];
    //방문 여부
    public static boolean visited[];
    public static ArrayList<Edge> list[];
    public static PriorityQueue<Edge> q = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        //값 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //노드개수
        V = Integer.parseInt(st.nextToken());
        //에지 개수
        E = Integer.parseInt(st.nextToken());
        //출발 노드
        K = Integer.parseInt(br.readLine());
        distance = new int[V+1];
        visited = new boolean[V+1];
        list = new ArrayList[V+1];
        //그래프 정보를 저장하는 인접 리스트 초기화
        for(int i = 0;  i<=V ; i++){
            list[i] = new ArrayList<Edge>();
        }
        //거리 배열은 충분히 큰 수로 초기화
        for(int i = 0 ; i<=V ; i++){
            distance[i] = Integer.MAX_VALUE;
        }

        //가중치가 있는 인접 리스트 초기화
        for(int i = 0 ; i<E ; i++){
            st= new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[u].add(new Edge(v,w));
        }
        //K를 시작점으로 설정
        q.add(new Edge(K,0));
        distance[K] = 0;
        while(!q.isEmpty()){
            Edge current = q.poll();
            int c_v = current.vertex;
            //이미 방문한 적이 있는 노드는 다시 큐에 넣지 앟는다.
            if(visited[c_v])continue;
            visited[c_v]=true;

            for(int i = 0 ; i<list[c_v].size(); i++){
                Edge tmp = list[c_v].get(i);
                int next= tmp.vertex;
                int value = tmp.value;

                //최소 거리로 업데이트 하기
                if(distance[next]>distance[c_v]+value){
                    distance[next] = value+distance[c_v];
                    q.add(new Edge(next, distance[next]));
                }
            }
        }
    //거리 배열 출력
    for(int i = 1 ; i<=V ; i++){
        if(visited[i])
            System.out.println(distance[i]);
        else System.out.println("INF");
    }
    }
}
class Edge implements Comparable<Edge> {
    int vertex, value;
    Edge(int vertex, int value){
        this.vertex = vertex;
        this.value = value;
    }

    //우선순위 큐 정렬 기준을 위한 함수 구현
    @Override
    public int compareTo(Edge e) {
        if(this.value > e.value) return 1;
        else return -1;
    }

}
