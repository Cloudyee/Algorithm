import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    static int[] parent;
    static PriorityQueue<pEdge> queue;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //노드 수
        int N = sc.nextInt();
        //에지 수
        int M = sc.nextInt();
        //자동정렬을 위해 우선순위 큐 자료구조 사용
        queue = new PriorityQueue<>();
        //노드의 수만큼 초기화
        parent = new int[N + 1];
        for(int i = 0 ; i<N ; i++){
            parent[i] = i;
        }
        //에지 리스트에 값 저장
        for (int i = 0; i < M; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            int v = sc.nextInt();
            queue.add(new pEdge(s, e, v));
        }

        int useEdge = 0;
        int result = 0;
        while (useEdge < N - 1) {
            pEdge now = queue.poll();
            //같은 부모가 아니라면 연결해도 사이클이 생기지 않는다.
            if (find(now.s) != find(now.e)) {
                union(now.s, now.e);
                result = result + now.v;
                useEdge++;
            }
        }
        System.out.println(result);
    }

    //union연산 : 대표 노드끼리 연결하기
    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            parent[b] = a;
        }
    }

    //find연산
    public static int find(int a) {
            if (a == parent[a])
                return a;
            else
                //재귀 함수 형태로 구현 -> 경로 압축 부분
                return parent[a] = find(parent[a]);
    }
}
class pEdge implements Comparable<pEdge>{
        int s, e, v;
        pEdge(int s, int e, int v){
            this.s = s;
            this.e = e;
            this.v = v;
        }

    @Override
    public int compareTo(pEdge o) {
        //가중치를 기주능로 오름차순 정렬을 하기 위해 compareTo 재정의
        return this.v - o.v;
    }
}
