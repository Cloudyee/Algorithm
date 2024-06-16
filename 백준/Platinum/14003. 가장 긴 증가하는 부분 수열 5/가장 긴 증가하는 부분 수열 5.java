import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int maxLength; //최장길이 저장 값
    static int B[] = new int [1000001]; //현재 가장 유리한 증가 수열 저장
    static int A[] = new int [1000001]; //입력 수열 저장
    static int D[] = new int [1000001]; //최장 증가 수열의 기링 저장
    static int ans[] = new int [1000001]; //정답 저장

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());        //수열 A의 크기 N
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i  = 1 ; i<= N ; i++){
            A[i] = Integer.parseInt(st.nextToken()); //입력값들을 A수열에 저장
        }
        int index;
        B[++maxLength] = A[1];
        D[1] = 1; //0부터 1까지에서 최장 수열의 길이는 1
        for(int i =2 ; i<=N ; i++){
            if(B[maxLength] < A[i]){ //가장 마지막 수열보다 현재 수열이 더 클 경우
                B[++maxLength] = A[i];
                D[i] = maxLength;
            }else{
                //B배열에서 data[i]보다 **처음으로 크거나 같아지는** 원소의 index찾기
                index = binaryserach(1, maxLength , A[i]);
                B[index]=A[i];
                D[i] = index;
            }
        }
        System.out.println(maxLength); //가장 길고 증가하는 부분의 수열 길이 출력
        index = maxLength;
        int x = B[maxLength]+1;
        for(int i = N ; i>=1 ; i--){
            //뒤에서 부터 탐색하면서 정답 수열 저장하기
            if(D[i] == index && A[i]<x){
                ans[index] = A[i];
                x = A[i];
                index--;
            }
        }
        for(int i = 1 ; i<=maxLength ; i++){
            System.out.print(ans[i]+" ");
        }
    }

    //현재 수열이 들어갈 수 있는 위치를 빠르게 찾아 주기 위한 바이너리 서치 구현하기
    //TODO : 바이너리 서치 개념 복습
    static int binaryserach(int l , int r , int now){
        int mid;
        while(l<r){
            mid = (l+r)/2;
            if(B[mid] < now)
                l = mid+1;
            else
                r = mid;
        }
        return l;
    }
}
