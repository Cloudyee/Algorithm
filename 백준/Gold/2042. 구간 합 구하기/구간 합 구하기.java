import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //수의 개수
        int N = Integer.parseInt(st.nextToken());
        //변경이 일어나는 횟수
        int M = Integer.parseInt(st.nextToken());
        //구간 합을 구하는 횟수
        int K = Integer.parseInt(st.nextToken());
        int treeHeight = 0;
        int length = N;
        //트리 높이 계산
        while(length != 0){
            length /= 2;
            treeHeight++;
        }
        //트리 사이즈 구하기
        int treeSize = (int)Math.pow(2, treeHeight+1);
        //리프 노드 시작 인덱스
        int leftNodeStartIndex = treeSize/2 -1;
        tree = new long[treeSize+1];
        //데이터를 리프 노드에 입력받기
        for(int i = leftNodeStartIndex+1 ; i<=leftNodeStartIndex+N ; i++){
            tree[i] = Long.parseLong(br.readLine());
        }
        //tree 만들기
        setTree(treeSize-1);

        for(int i = 0 ; i<M+K ; i++){
            st= new StringTokenizer(br.readLine());
            long a = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            long e = Long.parseLong(st.nextToken());
            if(a==1){
                //변경
                changeVal(leftNodeStartIndex+s , e);
            } else if(a==2){
                //구간 합
                s = s+leftNodeStartIndex;
                e = e+leftNodeStartIndex;
                System.out.println(getSum(s, (int)e));
            }else {
                return;
            }
        }
        br.close();
    }

    //구간 합을 구하는 함수
    private static long getSum(int s , int e){
        long partSum = 0;
        while(s<=e){
            if(s%2 ==1){
                partSum = partSum+tree[s];
                s++;
            }
            if (e%2 == 0){
                partSum = partSum+tree[e];
                e--;
            }
            s=s/2;
            e=e/2;
        }
        return partSum;
    }


    //값을 변경하는 함수
    private static void changeVal(int index, long val){
        long diff = val - tree[index];
        while(index>0){
            tree[index]=tree[index]+diff;
            index = index/2;
        }
    }

    //초기 트리를 구성하는 함수
    private static void setTree(int i){
        while(i!=1){
            tree[i/2]+=tree[i];
            i--;
        }
    }
}
