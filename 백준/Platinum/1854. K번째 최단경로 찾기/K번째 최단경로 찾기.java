import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int N, M , K;
        //N의 최대값이 1000이므로
        int[][]W = new int[1001][1001];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //도시 갯수
        N = Integer.parseInt(st.nextToken());
        //도로의 수
        M =  Integer.parseInt(st.nextToken());
        //최단 경로
        K = Integer.parseInt(st.nextToken());
        
        PriorityQueue<Integer>[] distQueue = new PriorityQueue[N+1];
        //오름차순 정렬 기준
       Comparator<Integer> cp = new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1<o2 ? 1:-1;
            }
        };


       for(int i = 0 ; i<N+1; i++){
            distQueue[i] = new PriorityQueue<Integer>(K, cp);
       }
       //인접 행렬에 그래프 데이터 저장
        for(int i = 0 ; i<M ; i++ ){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b= Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            W[a][b]=c;
        }

        PriorityQueue<Node2> pq = new PriorityQueue<>();
        pq.add(new Node2(1,0));
        distQueue[1].add(0);
        while(!pq.isEmpty()){
            Node2 u = pq.poll();
            for(int adjNode = 1 ; adjNode <=N ; adjNode++){
                //연결된 모든 노드로 검색하기
                //이로인해 시간복잡도 측면에서 인접 행렬이 불리하다.
                if(W[u.node][adjNode]!=0){
                    //지정된 경로가 K개가 안 될 때는 그냥 추가
                    if(distQueue[adjNode].size()<K){
                        distQueue[adjNode].add(u.cost+W[u.node][adjNode]);
                        pq.add(new Node2(adjNode, u.cost+W[u.node][adjNode]));
                        //저장된 경로가 K개이고, 혀냊 가장 큰 값보다 작을 때만 추가
                    }else if(distQueue[adjNode].peek()>u.cost+W[u.node][adjNode]){
                        //기존 큐에서 Max값을 먼저 삭제
                        distQueue[adjNode].poll();
                        distQueue[adjNode].add(u.cost+W[u.node][adjNode]);
                        pq.add(new Node2(adjNode, u.cost+W[u.node][adjNode]));
                    }
                }
            }
        }

        //K번째 경로 출력하기
        for(int i = 1;  i<=N ; i++){
            if(distQueue[i].size()==K){
                bw.write(distQueue[i].peek()+"\n");
            }else{
                bw.write(-1+"\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

//가중치가 있는 그래프를 담기 위한 노드 클래스
class Node2 implements Comparable<Node2>{
    int node;
    int cost;
    Node2(int node, int cost){
        this.node = node;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node2 o) {
        return this.cost < o.cost ?-1:1;
    }
}
