import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static int N, M ;
    //인접 리스트로 그래프 표현
    static ArrayList<Node>[] list;
    //최단 거리 배열
    static int[] dist;
    //사용 노드인지 확인하는 배열
    static boolean[] visit;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        //도시 수(노드 수)
        N=Integer.parseInt(br.readLine());
        //버스의 개수(에지 개수)
        M=Integer.parseInt(br.readLine());
        //이외 배열들의 크기 초기화
        list=new ArrayList[N+1];
        dist = new int[N+1];
        visit = new boolean[N+1];
        //거리 배열을 충분히 큰 수로 초기화
        Arrays.fill(dist, Integer.MAX_VALUE);
        //인접 리스트 배열 초기화
        for(int i = 0 ; i<=N ; i++){
            list[i]  = new ArrayList<Node>();
        }

        //주어진 그래프의 에지를 인접 리스트 자료구조에 넣기
        for(int i = 0 ; i<M ; i++){
            st = new StringTokenizer(br.readLine());
            //출발 도시 번호
            int start = Integer.parseInt(st.nextToken());
            //도착지 도시 번호
            int end = Integer.parseInt(st.nextToken());
            //버스 비용
            int weight = Integer.parseInt(st.nextToken());
            //인접 리스트에 Node 자료구조로 저장
            list[start].add(new Node(end, weight));
        }

        st = new StringTokenizer(br.readLine());
        //구하고자 하는 출발점 도시 번호
        int startIndex = Integer.parseInt(st.nextToken());
        //구하고자 하는 도착점 도시 번호
        int endIndex = Integer.parseInt(st.nextToken());
        
        //다익스트라 알고리즘 수행
        bw.write(dijkstra(startIndex, endIndex)+"\n");
        bw.flush();
        bw.close();
        br.close();

    }

    //다익스트라 알고리즘 구현
    public static int dijkstra(int start, int end){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        dist[start]=0;
        while(!pq.isEmpty()){
            Node nowNode = pq.poll();
            int now = nowNode.targetNode;
            if (!visit[now]){
                visit[now]= true;
                //선택 노드 + 비용 < 타깃 노드일 때에 값을 업데이트
                for(Node n : list[now]){
                    if(!visit[n.targetNode] && dist[n.targetNode]>dist[now]+n.value){
                        dist[n.targetNode] = dist[now]+n.value;
                        pq.add(new Node(n.targetNode, dist[n.targetNode]));
                    }
                }
            }
        }

        return dist[end];
    }
}

//가중치가 있는 그래프를 담기 위한 별도의 클래스 구현
class Node implements Comparable<Node>{
    int targetNode, value;

    Node(int targetNode , int value){
        this.targetNode = targetNode;
        this.value = value;
    }
    //우선순위 큐 정렬 기준을 위해 compareTo 함수 구현
    @Override
    public int compareTo(Node o) {
        return value - o.value;
    }
}