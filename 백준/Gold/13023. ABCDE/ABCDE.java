import java.util.ArrayList;
import java.util.Scanner;
/*
주어진 모든 노드에 DFS를 수행한다.
재귀의 깊이가 5 이상이면 1, 아니라면 0을 출력한다.
 */
public class Main {
    //방문여부 기록
    static boolean visited[];
    //인접 리스트
    static ArrayList<Integer>[] A;

    static boolean arrive;

    public static void main(String[] args) {
        //노드 개수
        int N;
        //에지 개수
        int M;

        arrive = false;

        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();
        A=new ArrayList[N];
        visited=new boolean[N];
        for(int i = 0 ; i<N ; i++){
            A[i] = new ArrayList<Integer>();
        }
        for(int i = 0; i < M ; i++){
            int S = scan.nextInt();
            int E = scan.nextInt();
            //양방향 에지
            A[S].add(E);
            A[E].add(S);
        }

        for(int i = 0 ; i<N ; i++){
            //depth 1부터 시작
            DFS(i, 1);
            if(arrive)
                break;
        }
        if(arrive)
            System.out.println("1");
        else System.out.println("0");
    }
    
    //DFS 구현
    public static void DFS(int now, int depth){
        //depth가 5가 되면 프로그램 종료
        if(depth==5 || arrive){
            arrive=true;
            return;
        }
        visited[now]=true;
        for(int i : A[now]){
            //재귀함수가 호출될 때 마다 depth 1씩 증가
            if(!visited[i])
                DFS(i,depth+1);
        }
        visited[now]=false;
    }
}
