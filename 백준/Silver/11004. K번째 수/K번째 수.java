import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    //퀵 소트를 활용한다.

    public static int partition(int[]A, int start , int end){
        if(start+1== end){
            if(A[start]>A[end]){
                swap(A, start , end);
            }
            return end;
        }

        int middle = (start+end)/2;
        swap(A, start , middle);
        int pivot = A[start];

        int i = start+1;
        int j = end;

        while(i<=j){
            //피벗보다 작은 수가 나올 때 까지 j--
            while(j>=start+1 && pivot < A[j])
                j--;
            //피벗보다 큰 수가 나올 때 까지 i++
            while(i<=end && pivot>A[i])
                i++;
            if(i<=j)
                swap(A, i++, j--);
        }

        //피벗 데이터를 나누어진 두 그룹의 경계 index에 저장
        A[start] = A[j];
        A[j]= pivot;
        return j ;
    }

    //swap 메소드
    public static void swap(int[] A,  int first , int second){
        int temp = A[first];
        A[first] = A[second];
        A[second] = temp;
    }

    public static void quickSort(int []A, int start , int end , int k){
        if(start < end){
            int pivot = partition(A, start , end);
            if(pivot == k )
                return;
            else if(k<pivot)
                quickSort(A, start , pivot - 1 , k);
            else quickSort(A, pivot+1, end , k);

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        int A [] = new int [N];
        for(int i = 0 ; i<N ; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        quickSort(A, 0, N-1, K-1);
        System.out.println(A[K-1]);
    }
}
