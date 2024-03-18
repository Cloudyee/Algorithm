import java.util.*;

public class Main{
    static ArrayList<Integer>[] graph;
    static int[] distance;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt(); // 도시의 개수
        int M = scan.nextInt(); // 도로의 개수
        int K = scan.nextInt(); // 거리 정보 K
        int X = scan.nextInt(); // 출발 도시 번호

        graph = new ArrayList[N + 1];
        distance = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            distance[i] = -1; // 모든 도시에 대한 최단 거리 초기화
        }

        // 그래프 생성
        for (int i = 0; i < M; i++) {
            int A = scan.nextInt();
            int B = scan.nextInt();
            graph[A].add(B);
        }

        // BFS 탐색
        bfs(X);

        // 출력
        boolean found = false; // 최단 거리가 K인 도시를 찾았는지 여부
        for (int i = 1; i <= N; i++) {
            if (distance[i] == K) { // 최단 거리가 K인 도시라면 출력
                System.out.println(i);
                found = true;
            }
        }

        if (!found) { // 최단 거리가 K인 도시를 찾지 못한 경우 -1 출력
            System.out.println("-1");
        }
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        distance[start] = 0; // 시작 도시의 최단 거리는 0

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next : graph[current]) {
                if (distance[next] == -1) { // 방문하지 않은 도시라면
                    distance[next] = distance[current] + 1; // 최단 거리 갱신
                    queue.offer(next); // 큐에 추가하여 다음에 탐색
                }
            }
        }
    }
}
