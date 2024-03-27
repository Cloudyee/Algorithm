import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //학생 수
        int N = sc.nextInt();
        //비교 횟수
        int M = sc.nextInt();

        //학생 수 만큼 진입차수 초기화
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        for(int i = 0 ; i<=N ; i++){
            A.add(new ArrayList<>());
        }
        
        //진입차수 배열
        int [] indegree = new int[N+1];
        for(int i = 0 ; i<M ; i++){
            int S  = sc.nextInt();
            int E = sc.nextInt();
            A.get(S).add(E);
            indegree[E] ++;
        }
        //위상 정렬 수행하기
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1 ; i<=N ; i++){
            if (indegree[i] == 0){
                //진입 차수 배열이 0인 학생을 큐에 삽입
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()){
            //현재 노드 값
            int now = queue.poll();
            System.out.println(now + " ");
            //현재 노드에서 갈 수 있는 노드의 수 만큼 반복
            for(int next : A.get(now)){
                //타깃 노드 진입차수 배열 --
                indegree[next]--;
                if(indegree[next]==0){
                    //큐에 타깃 노드 추가
                    //큐에 타깃 노드 추가
                    queue.offer(next);
                }
            }
        }
    }
    
}
