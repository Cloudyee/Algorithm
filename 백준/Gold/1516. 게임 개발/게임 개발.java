import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //건물 종류 수
        int N = Integer.parseInt(br.readLine());
        //건물의 개수만큼 인접 리스트 초기화
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        for(int i = 0 ;i<=N ; i++){
            A.add(new ArrayList<>());
        }
        //진입차수 배열
        int [] indegree = new int[N+1];
        //자기 자신을 짓는데 걸리는 시간
        int [] selfBuild = new int[N+1];

        for(int i = 1 ; i<=N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            //건물을 짓는데 걸리는 시간
            selfBuild[i] = Integer.parseInt(st.nextToken());
            //인접 리스트 초기화
            while(true){
                int preTemp = Integer.parseInt(st.nextToken());
                if(preTemp ==-1)
                    break;
                A.get(preTemp).add(i);
                //진입차수 배열 초기화
                indegree[i] ++;
            }
        }

            //위상정렬
            Queue<Integer> queue = new LinkedList<>();
            for(int i = 1 ; i<=N ; i++){
                if(indegree[i] == 0){
                    queue.offer(i);
                }
            }

            int [] result = new int[N+1];
            while(! queue.isEmpty()){
                int now = queue.poll();
                for(int next : A.get(now)){
                    indegree[next]--;
                    //시간 업데이트 하기
                    result[next] = Math.max(result[next], result[now]+selfBuild[now]);
                    if(indegree[next]==0)
                        queue.offer(next);
                }
            }
            for(int i = 1 ; i<=N ; i++){
                System.out.println(result[i] + selfBuild[i]);
            }
    }
}
