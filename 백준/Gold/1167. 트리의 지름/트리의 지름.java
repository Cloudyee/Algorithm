import java.util.*;

public class Main {
    //방문 여부
    static boolean visited[];
    //거리
    static int[] distance;
    //그래프 데이터 저장 인접리스트
    static ArrayList<Edge>[] A;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //노드 개수
        int N = sc.nextInt();
        //노드의 개수만큼 인접 리스트 선언
        A = new ArrayList[N+1];

        for(int i = 1 ; i<=N ; i++){
            A[i] = new ArrayList<Edge>();
        }

        //인접 리스트에 그래프 데이터 저장
        for(int i = 0; i<N ; i++){
            int S = sc.nextInt();
            while(true){
                int E = sc.nextInt();
                if(E==-1)
                    break;
                int V = sc.nextInt();
                A[S].add(new Edge(E,V));
            }
        }
        distance = new int [N+1];
        visited = new boolean[N+1];
        BFS(1);
        int Max = 1;
        //distance 배열에서 가장 큰 값으로 다시 시작점을 설정
        for(int i = 2; i<=N ; i++){
            if(distance[Max]<distance[i])
                Max=i;
        }

        distance=new int[N+1];
        visited=new boolean[N+1];
        BFS(Max);
        Arrays.sort(distance);
        System.out.println(distance[N]);
    }
    
    //BFS구현
    private static void BFS(int index){
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(index);
        //방문 여부 설정
        visited[index]=true;

        //큐 안의 값이 빌 때 까지 반복
        while(!queue.isEmpty()){
            //큐에 저장된 값을 꺼내 활용
            int now_node = queue.poll();
            //현재 노드의 에지 값을 활용한다.
            for(Edge i : A[now_node]){
                int e = i.e;
                int v = i.value;
                if(!visited[e]){
                    visited[e]=true;
                    queue.add(e);
                    //거리 배열 업데이트
                    distance[e] = distance[now_node]+v;
                }
            }
        }
    }
    
}
    //에지 클래스
    class Edge{
        int e ;
        int value;
        public Edge(int e, int value){
            this.e= e;
            this.value=value;
        }
    }
