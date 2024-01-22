import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    //병합 정렬을 활용하여
    //버블 정렬시 일어나는 swap 횟수를 센다.

    public static int[] A;
    public static int[] tmp;
    public static long result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        A= new int[N+1];
        tmp = new int [N+1];

        StringTokenizer st= new StringTokenizer(br.readLine());
        for(int i = 1 ; i<=N ; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        result = 0;
        //병합 정렬 수행
        merget_sort(1, N);
        System.out.println(result);
    }

    private static void merget_sort(int start , int end){
        if(end-start < 1)
            return;

        int medium = start+(end-start)/2;

        //재귀함수 형태로 구현
        merget_sort(start, medium);
        merget_sort(medium+1, end);
        for(int i = start ; i<= end ; i++){
            tmp[i]=A[i];
        }

        int k = start;
        int index1 = start;
        int index2 = medium+1;
        while(index1 <= medium && index2<=end){
            if(tmp[index1]>tmp[index2]){
                A[k] = tmp[index2];
                //뒤쪽 데이터 값이 작은 경우 result 업데이트
                result = result + index2 - k;
                k++;
                index2++;
            }else{
                A[k]=tmp[index1];
                k++;
                index1++;
            }
        }

        //값의 정렬이 끝난 후 남은 값들은 뒷쪽에 추가해준다.
        while(index1 <= medium){
            A[k]=tmp[index1];
            k++;
            index1++;
        }
        while(index2<=end){
            A[k]=tmp[index2];
            k++;
            index2++;
        }
    }
}
