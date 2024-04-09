import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    private static BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M;
    static long distance[];
    static TimeMachineEdge edges[];

    public static void main(String[] args) throws  Exception{
        StringTokenizer st= new StringTokenizer(br.readLine());
        //노드 개수
        N=Integer.parseInt(st.nextToken());
        //에지 개수
        M=Integer.parseInt(st.nextToken());
        edges=new TimeMachineEdge[M+1];
        distance=new long[N+1];
        //최단 거리 배열 초기화
        Arrays.fill(distance, Integer.MAX_VALUE);
        //에지 리스트에 데이터 작성
        for(int i = 0 ; i<M ; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            edges[i]=new TimeMachineEdge(start, end, time);
        }

        //벨만-포드 알고리즘 수행
        distance[1] = 0;
        //N보다 1개 적은 수만큼 반복
        for(int i = 1 ; i<N ; i++){
            for(int j = 0 ; j<M ; j++){
                TimeMachineEdge edge=edges[j];
                
                //더 작은 최단 거리가 있을 떄 업데이트
                if(distance[edge.start] != Integer.MAX_VALUE
                && distance[edge.end]>distance[edge.start]+edge.time){
                    distance[edge.end] = distance[edge.start]+edge.time;
                }
            }
        }
        boolean mCycle = false;
        //음수 사이클 확인하기
        for(int i = 0 ; i<M ; i++){
            TimeMachineEdge edge = edges[i];
            if(distance[edge.start] != Integer.MAX_VALUE
                    && distance[edge.end]>distance[edge.start]+edge.time){
                mCycle=true;
            }
        }
        //음수 사이클이 없는 경우
        if(!mCycle){
            for(int i = 2 ; i<=N ; i++){
                if(distance[i]==Integer.MAX_VALUE){
                    System.out.println("-1");
                }else
                    System.out.println(distance[i]);
            }
            //음의 사이클이 있을때
        }else System.out.println("-1");
    }


}
    //에지 리스트를 편하게 다루기 위한 별도의 클래스 구현
    class TimeMachineEdge{
        //시작점, 도착점, 걸리는 시간
        int start, end, time;
        public TimeMachineEdge(int start, int end, int time){
            this.start=start;
            this.end=end;
            this.time=time;
        }
    }
