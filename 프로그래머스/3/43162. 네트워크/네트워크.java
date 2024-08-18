import java.util.*;

class Solution {
        //* 어딘지 기억은 안나는데 기출문제다
        public int solution ( int n, int[][] computers){
        //computers[i][j] 가 1이면 i번 컴퓨터가 j번 컴퓨터와 연결되어 있는 것
        //* 각 컴퓨터를 노드로 보고, 관계를 간선으로 본다.
        //-> 즉, 그래프에서 연결 요소의 수를 찾는 문제로 생각할 수 있다.
        // ****여기까지 새각해냈으나 구현방법의 무지로 시작하지도 못함....

        int answer = 0;

        //방문 여부 체크 : 각 컴퓨터가 이미 탐색된 네트워크에 포함되어있는지 표시
        // 이미 탐색한 컴퓨터는 다시 탐색하지 않는다.
        boolean[] visited = new boolean[n];

        for(int i =  0 ; i<n ; i++){
            // 방문 하지 않은 경우 answer에 값을 더해주고,
            // 순회하며 탐색을 시행한다.
            if(!visited[i]){
                answer++;
                //1 - DFS를 사용하여 연결되는 모든 컴퓨터를 방문한다.
                dfs(computers, visited , i);

                //2 - BFS를 사용해 연결되는 모든 컴퓨터를 방문할 경우
                //bfs(computers, visited, i);
            }
        }

        return answer;
    }

    //깊이우선탐색 : dfs는 보통 재귀함수 활용
    private static void dfs(int[][]computers , boolean[]visited , int node){
        // 방문 여부 체크
        visited[node] = true;
        //node와 연결된 컴퓨터 여부를 반복 탐색
        for(int i = 0 ; i<computers.length ; i++){
            if(
            i!=node
            && !visited[i]
            && computers[node][i] == 1){
                dfs(computers, visited, i); //재귀 호출을 통해 연결된 모든 컴퓨터를 방문한다.ㄴ
            }
        }
    }

    //너비우선탐색 bfs는 queue를 활용한다.
    private static void bfs(int[][] computers , boolean[]visited , int node){
        visited[node] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        //여기부터 혼자 생각해내질 못했음...
        while(!queue.isEmpty()){
            int currentNode = queue.poll();
            
            for(int i = 0 ; i < visited.length ; i++){
                if(
                currentNode != i 
                && !visited[i]
                && computers[currentNode][i] == 1
                ){
                    visited[i] = true;
                    queue.add(i); //큐에 추가하여 연결된 모든 컴퓨터를 방문
                }
            }
        }
    }
}