import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    //인접 리스트
    static ArrayList<cNode>[] A;
    //최소 공배수
    static long lcm;
    //DFS 수행시 탐색 여부 저장 배열
    static boolean visited[];
    //각 노드 값 저장 배열
    static long D[];

    public static void main(String[] args) throws  Exception{
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //재료 개수
        int N = sc.nextInt();
        A = new ArrayList[N];
        visited=new boolean[N];
        D = new long[N];
        lcm = 1;
        //인접 리스트 배열에 에지 정보 저장
        for(int i = 0 ; i<N ; i++){
            A[i] = new ArrayList<cNode>();
        }

        for(int i = 0 ; i<N-1 ; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int p = sc.nextInt();
            int q = sc.nextInt();
            A[a].add(new cNode(b,p,q));
            A[b].add(new cNode(a, q, p));
            //최소 공배수는 두 수의 곱으 ㄹ최대 공약수로 나눈 것
            lcm *=(p*q/gcd(p,q));
        }
        D[0] = lcm;
        DFS(0);
        long mgcd=D[0];
        for(int i = 1 ; i<N ; i++){
            mgcd = gcd(mgcd , D[i]);
        }
        for(int i = 0; i<N ; i++){
            System.out.print(D[i]/mgcd+ " ");
        }
    }

    //최대 공약수 함수 구현하기
    public static long gcd(long a, long b){
        if(b==0)
            return a;
        else return gcd(b, a%b);
    }

    //DFS 구현하기
    public static void DFS(int Node){
        visited[Node]=true;
        for(cNode i : A[Node]){
            int next = i.getB();
            if(!visited[next]){
                //주어진 비율로 다음 노드 값 갱신
                D[next] = D[Node]*i.getQ()/i.getP();
                DFS(next);
            }
        }
    }
}
    //노드 클래스 선언
    class cNode{
        int b;
        int p;
        int q;

        public cNode(int b, int p, int q){
            super();
            this.b = b;
            this.p = p;
            this.q = q;
        }
        public int getB(){
            return b;
        }

        public int getP(){
            return p;
        }

        public int getQ(){
            return q;
        }
    }
