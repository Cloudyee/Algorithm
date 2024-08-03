import java.util.*;
class Solution {
    //상하좌우 이동을 위한 방향 배열.
    //손으로 그려보면 이해가 빠르다.
    static final int[] dx = {1, 0, -1, 0};
    static final int[] dy = {0, 1, 0, -1};
    
    static int n, m;
    static boolean[][] visited;
    static int answer;
    
    public int solution(int[][] maps) {
        /*
        [아직 풀지 못한 문제] : 추후 공부하여 스스로의 힘으로 풀어보자....
        최단거리 문제에서는 BFS를 사용하는 것이 좋다.
        - BFS구현시에는 Queue를 활용한다.
        - Queue를 활용해 현재 위치에서 가능한 모든 이동을 처리하고, 다음단계의 위치와 거리정보를 추가한다.
        
        탐색 과정에서 각 좌표와 거리정보를 함께 저장한다.
        - BFS탐색 완료 후에도 도착하지 못한 경우 체크하여 -1을 반환한다.
        */
        
        //맵의 크기
        n = maps.length;
        m = maps[0].length;
        
        //방문 여부 체크 배열
        visited = new boolean[n][m];
        
        //최단 거리를 저장
        answer = Integer.MAX_VALUE;
        
        //BFS 메서드 실행
        bfs(maps);
        
        //도착하지 못한 경우  == answer가 바뀌지 않은 경우 -1 반환
        if(answer == Integer.MAX_VALUE)
            return -1;
      
        return answer;
    }

    //너비 우선 탐색(BFS) 메서드
    static void bfs(int[][] maps){
       //큐 생성 후 좌표 (x, y)와 이동 거리 저장
        Queue<int[]> queue = new LinkedList<>();
        
        //시작점(0,0)과 거리 1을 큐에 추가
        //즉, 큐 내부에는 각각 (x, y, 이동거리) 배열이 저장되는 것.
        queue.add(new int[]{0,0,1});
        
        visited[0][0] = true;
        
        //큐가 빌 때 까지 아래 로직을 반복
        while(!queue.isEmpty()){
            //큐에서 현재 좌표와 거리 추출
            int[] currInfo = queue.poll();
            int x = currInfo[0];
            int y = currInfo[1];
            int distance = currInfo[2];
            
            //상하좌우로 이동]
            for(int i = 0 ; i<4 ; i++){
                int nextX = x + dx[i];
                int nextY = y + dy[i];
                
                //맵의 범위를 벗어나지 않고 && 방문하지 않은 위치 &&  값이 1인 경우
                if( nextX >= 0 && nextY >= 0 
                   && nextX < n && nextY <m 
                   && !visited[nextX][nextY] 
                   && maps[nextX][nextY] == 1){
                    //방문 여부 저장
                    visited[nextX][nextY] = true;
                    //다음 위치와 거리+1을 큐에 저장
                    queue.add(new int[]{nextX, nextY, distance+1});
                    
                    //도착점(n-1, m-1)에 도달시 최단거리 업데이트
                    if(nextX == n-1 && nextY == m-1){
                        answer = Math.min(answer, distance + 1);
                    }
                }
            }
        }
    }
}