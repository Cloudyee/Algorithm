import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    //DFS방식을 이해한다.

    //그래프 데이터 저장 인접 리스트
    static ArrayList<Integer> [] A;

    //방문 기록 저장 배열
    static boolean visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //노드 개수
        int n = Integer.parseInt(st.nextToken());
        //에지 개수
        int m = Integer.parseInt(st.nextToken());

        //노드 갯수에 맞추어 생성
        A=new ArrayList[n+1];
        visited=new boolean[n+1];

        //인접 리스트 초기화
        for(int i = 1; i<n+1 ; i++){
            A[i]=new ArrayList<Integer>();
        }

        //인접 리스트에 그래프 데이터 저장
        for(int i = 0; i<m ; i++){
            st=new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            //양방향 에지이므로 양쪽에 에지를 더해줌
            A[s].add(e);
            A[e].add(s);
        }

        int count = 0;
        for(int i = 1 ; i< n+1 ; i++){
            //방문하지 않은 노드가 없을 때 까지 반복
            if(!visited[i]){
                count++;
                DFS(i);
            }
        }
        System.out.println(count);
    }

    static void DFS(int v){
        //방문하지 않은 경우만 실행
        if(visited[v]){
            return;
        }
        visited[v]=true;
        for(int i :A[v]){
            if(visited[i]==false){
                DFS(i);
            }
        }
    }
}
