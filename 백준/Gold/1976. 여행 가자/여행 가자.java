import java.util.Scanner;

public class Main {
    public static int[] parent;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //도시의 수
        int N = sc.nextInt();
        //여행 계획에 속한 도시들의 수
        int M = sc.nextInt();
        //여행 계획에 속한 도시
        int[][]dosi = new int[N+1][N+1];
        //도시 연결 데이터 저장
        for(int i = 1; i<=N ; i++){
            for(int j = 1 ; j<=N ; j++){
                dosi[i][j] = sc.nextInt();
            }
        }

        //여행 도시 정보 저장
        int[] route = new int[M+1];
        for(int i = 1 ; i<=M ; i++){
            route[i] = sc.nextInt();
        }

        //대표 노드
        parent = new int[N+1];
        //대표 노드를 자기 자신으로 초기화
        for(int i = 1 ; i<=N  ; i++){
            parent[i] = i;
        }

        //인접 행렬에서 도시가 연결돼있으면 union 실행
        for(int i  = 1;  i<=N ; i++){
            for(int j = 1; j<=N ; j++){
                if(dosi[i][j] == 1) union(i,j);
            }
        }

        //여행 계획 도시들이 1개의 대표 도시로 연결돼있는지 확인
        int index = find(route[1]);
        for(int i = 2 ; i<route.length ; i++){
            if(index != find(route[i])){
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    //union 연산 : 대표 노드끼리 연결
    public static void union(int a, int b){
        a=find(a);
        b=find(b);
        if(a!=b)
            parent[b]=a;
    }

    //find 연산
    public static int find(int a){
        if(a==parent[a])
            return a;
        else
            //재귀 함수 형태로 구현
            return parent[a]=find(parent[a]);
    }
}
