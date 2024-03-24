import java.util.Scanner;

public class Main {
    //대표 노드 저장 배열
    public static int[] parent;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //원소의 개수
        int N = sc.nextInt();
        //질의 개수
        int M = sc.nextInt();
        //대표 노드 크기 초기화
        parent = new int[N+1];

        //대표노드를 자기 자신으로 촉;화
        for(int i = 0 ; i<=N; i++){
            parent[i] = i;
        }

        for(int i = 0 ; i<M ; i++){
            int question = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();

            //유니온 연산(집합 합치기)
            if(question == 0){
                union(a,b);
            }else{
                //같은 집합의 원소인지 확인
                if(checkSame(a,b)){
                    System.out.println("YES");
                }else{
                    System.out.println("NO");
                }
            }
        }
    }

    //union연산 : 대표 노드끼리 연결
    public static void union(int a,  int b){
        a = find(a);
        b = find(b);
        if(a!=b){
            parent[b] = a;
        }
    }

    //find 연산
    public  static int find (int a){
        if(a==parent[a]){
            return a;
        }else{
            //재귀 함수의 형태로 구현하여 경로 압축
            return parent[a]= find(parent[a]);
        }
    }

    //두 원소가 같은 집합인지 확인
    public static boolean checkSame(int a , int b){
        a = find(a);
        b= find(b);
        if(a==b){
            return true;
        }else return false;
    }
}
