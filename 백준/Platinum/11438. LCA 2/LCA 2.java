import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] tree;
    static int[] depth;
    static int kmax;
    static int[][] parent;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //노드의 수
        int N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N+1];
        for(int i = 1 ; i<=N ; i++){
            tree[i] = new ArrayList<>();
        }

        //A 인접리스트에 그래프 데이터 저장
        for(int i = 0; i<N-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            tree[s].add(e);
            tree[e].add(s);
        }

        depth = new int[N+1];
        visited = new boolean[N+1];
        int temp = 1;
        kmax = 0;
        //최대 가능 depth 구하기
        while(temp<=N){
            //2의 배수씩 중가
            temp <<=1;
            kmax++;
        }
        parent = new int[kmax+1][N+1];
        BFS(1); //depth를 BFS를 이용해 구하기
        for(int k = 1; k<=kmax ; k++){
            for(int n = 1; n<=N ; n++){
                parent[k][n] = parent[k-1][parent[k-1][n]];
            }
        }
        //질의의 수
        int M = Integer.parseInt(br.readLine());
        for(int i = 0; i<M ; i++){
            //공통 조상을 구할 두 노드
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int LCA = excuteLCA(a,b);
            System.out.println(LCA);
        }
    }

    static int excuteLCA(int a , int b){
        //더 깊은 depth가 b가 되도록 변경
        if(depth[a]>depth[b]){
            int temp = a;
            a=b;
            b=temp;
        }
        //depth를 빠르게 맞추기
        for(int k = kmax ; k>=0 ; k--){
            if(Math.pow(2,k)<=depth[b]-depth[a]){
                if(depth[a]<=depth[parent[k][b]]){
                    b=parent[k][b];
                }
            }
        }
        //조상 빠르게 찾기
        for(int k = kmax ; k>=0; k--){
            if(parent[k][a] != parent[k][b]){
                a=parent[k][a];
                b=parent[k][b];
            }
        }
        int LCA = a;
        if(a!=b)
            LCA=parent[0][LCA];
        return  LCA;
    }
    //BFS
    private static void BFS(int node){
        Queue<Integer>queue = new LinkedList<>();
        queue.add(node);
        visited[node]=true;
        int level=1;
        int now_size=1;
        int count=0;
        while(!queue.isEmpty()){
            int now_node = queue.poll();
            for(int next : tree[now_node]){
                if(!visited[next]){
                    visited[next]=true;
                    queue.add(next);
                    parent[0][next]=now_node; //부모노드 저장하기
                    depth[next]=level;
                }
            }
            count++;
            if(count==now_size){
                count=0;
                now_size=queue.size();
                level++;
            }
        }
    }
}
