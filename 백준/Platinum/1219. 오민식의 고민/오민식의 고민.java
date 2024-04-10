import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M , sCity, eCity;
    static long distance[], cityMoney[];
    static SalesManEdge edges[];

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        sCity = Integer.parseInt(st.nextToken());
        eCity = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        edges=new SalesManEdge[M];
        distance = new long[N];
        cityMoney = new long[N];
        //최단 거리 배열 초기화하기
        Arrays.fill(distance, Long.MIN_VALUE);
        for(int i = 0 ; i<M ; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            edges[i] = new SalesManEdge(start, end, price);
        }
        st=new StringTokenizer(br.readLine());
        for(int i = 0 ; i<N ; i++){
            cityMoney[i] = Long.parseLong(st.nextToken());
        }
        distance[sCity]=cityMoney[sCity];
        //변형된 벨만포드 알고리즘 수행
        //양수 사이클이 전파되도록 충분히 큰 수로 반복
        for(int i = 0 ; i<=N+100 ; i++){
            for(int j = 0 ; j<M ; j++){
                int start = edges[j].start;
                int end = edges[j].end;
                int price = edges[j].price;
                //출발 노드가 방문하지 않은 노드일 경우 skip
                if(distance[start] == Long.MIN_VALUE) continue;
                //출발 노드가 야ㅐㅇ수 사이클에 연결된 노드라면 종료 노드도 연결 노드로 업데이트
                else if(distance[start] == Long.MAX_VALUE)
                    distance[end] = Long.MAX_VALUE;
                //더 많은 돈을 벌 수 있는 새로운 경로가 발견됐을 때 새로운 경로값으로 업데이트
                else if(distance[end] < distance[start]+cityMoney[end]-price){
                    distance[end]=distance[start]+cityMoney[end]-price;
                    //N-1번 반복 이후 업데이트 되는 종료 노드는 야수 사이클 연결 노드로 변경
                    if(i>=N-1) distance[end] = Long.MAX_VALUE;
                }
            }
        }
        //도착 불가능
        if(distance[eCity]==Long.MIN_VALUE) System.out.println("gg");
        //양수 사이클 연결돼 무한대로 돈을 벌 수 있을 경우
        else if(distance[eCity]==Long.MAX_VALUE) System.out.println("Gee");
        //이 외의 경우
        else System.out.println(distance[eCity]);
    }

}
//에지 리스트를 편하게 다루기 위해 클래스로 별도 구현
class SalesManEdge{
    int start, end , price; //시작점, 도착점, 걸리는 시간
    public SalesManEdge(int start, int end , int price){
        this.start = start;
        this.end = end;
        this.price = price;
    }
}