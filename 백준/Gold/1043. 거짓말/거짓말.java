import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    //대표 노드 저장 배열
    public static int[] parent;
    //진실을 아는 사람 데이터
    public static int[] trueP;
    //파티 데이터
    public static ArrayList<Integer>[] party;
     //결과값
    public static int result;

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        //사람 수
        int N = sc.nextInt();
        //파티 수
        int M = sc.nextInt();
        //진실을 아는 사람 수
        int T = sc.nextInt();
        result = 0;
        trueP=new int[T];

        //진실을 아는 사람의 정보 저장
        for(int i = 0 ; i<T ; i++){
            trueP[i] = sc.nextInt();
        }

        party = new ArrayList[M];
        //파티 데이터 저장
        for(int i = 0 ; i<M ; i++){
            party[i] = new ArrayList<>();
            int party_size = sc.nextInt();
            for(int j = 0 ; j<party_size ; j++){
                party[i].add(sc.nextInt());
            }
        }

        parent = new int[N+1];
        //대표 노드를 자기 자신으로 초기화
        for(int i = 0 ; i<=N;i++){
            parent[i] = i;
        }

        //각 파티에 참여한 사람들을 한개의 그룹으로 만들기
        for(int i = 0 ; i<M ; i++){
            int firstPeople  = party[i].get(0);
            for(int  j = 1 ; j<party[i].size() ; j++){
                union(firstPeople , party[i].get(j));
            }
        }

        //각 파티의 대표 노드와 진실을 아는 사람들의 노드가 같다면 과장할 수 없다.
        for(int i = 0 ; i<M ; i++){
            boolean isPossible = true;
            int cur = party[i].get(0);

            for(int j = 0 ; j<trueP.length; j++){
                if(find(cur) == find (trueP[j])){
                    isPossible = false;
                    break;
                }
            }

            //모두 다르면 결과값 1 증가
            if(isPossible) result++;
        }
        System.out.println(result);
    }

    //union 연산
    public static void union(int a, int b){
        a =  find(a);
        b = find(b);
        if(a!=b){
            parent[b] =  a;
        }
    }

    //find 연산
    public static int find(int a){
        if(a == parent[a])
            return a;
        else
            return parent[a]  = find(parent[a]);
    }

    //두 원소가 같은 집핮ㅂ인지 확인
    public static boolean checkSame(int a, int b){
        a = find(a);
        b = find(b);
        if(a==b){
            return true;
        }
        return false;
    }

}
