import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static ArrayList<Integer>[] tree;
    static int[] depth;
    static int[] parent;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //노드의 수
        tree = new ArrayList[N+1];
        for(int i = 1 ; i<=N ; i++){
            tree[i] = new ArrayList<Integer>();
        }

        //A 인접 리스트에 그래프 데이터 저장하기
        for(int i = 0; i<N-1 ; i++){
            int s = sc.nextInt();
            int e = sc.nextInt();
            tree[s].add(e);
            tree[e].add(s);
        }
        depth = new int[N+1];
        parent = new int[N+1];
        visited = new boolean[N+1];
        //depth.를 BFS를 이용해 구하기
        BFS(1);
        int M  = sc.nextInt();
        for(int i = 0 ; i<M ; i++){
            //공통 조상을 구할 두 노드
            int a = sc.nextInt();
            int b = sc.nextInt();
            int LCA = excuteLCA(a,b);
            System.out.println(LCA);

        }
    }

    static int excuteLCA(int a, int b){
        if (depth[a] < depth[b]){
            int temp = a;
            a=b;
            b=temp;
        }
        //두 노드의 depth 맞추기
        while(depth[a] != depth[b]){
            a = parent[a];
        }
        //같은 조상이 나올 때까지 한 칸씩 올리기
        while (a!=b){
            a=parent[a];
            b=parent[b];
        }
        return a;
    }

    //BFS구현히기
    private static void BFS(int node){
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(node);
        visited[node] = true;
        int level = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int now_node = queue.poll();
                for(int next : tree[now_node]){
                    if(!visited[next]){
                        visited[next]=true;
                        queue.add(next);
                        //부모노드 저장하기
                        parent[next] = now_node;
                        //노드 depth 저장하기
                        depth[next]=level;
                    }
                }
            }
            level++;
        }
    }
}
