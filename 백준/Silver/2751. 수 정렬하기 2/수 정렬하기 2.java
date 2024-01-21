import java.io.*;

public class Main {
    //정렬할 배열
    public static int[] A;

    //정렬시 사용할 임시배열
    public static int[] tmp;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //정렬할 수의 갯수
        int N = Integer.parseInt(br.readLine());

        A=new int[N+1];
        tmp=new int[N+1];
        for(int i = 1; i<=N ; i++){
            A[i]=Integer.parseInt(br.readLine());
        }

        //병합 정렬 수행
        merget_sort(1,N);

        for(int i = 1; i<=N ; i++){
            bw.write(A[i]+"\n");
        }
        bw.flush();
        bw.close();
    }

    private static void merget_sort(int start , int end){
        //입력 수의 갯수가 하나 이하일 경우
        if(end - start<1){
            return;
        }
        //중간값 설정
        int medium = start + (end - start)/2;

        //재귀 함수 형태로 구현한다.
        merget_sort(start, medium);
        merget_sort(medium+1, end);

        for(int i = start ; i<=end ; i++){
            tmp[i]=A[i];
        }

        int k = start ;
        int index1 = start;
        int index2 = medium+1;

        //두 그룹을 병합하는 로직
        while(index1 <= medium && index2<=end){
            //양쪽 그룹의 index가 가리키는 값을 비교해 더 작은 수를 선택해 배열에 저장하고,
            //선택된 데이터의 index값을 오른쪽으로 한 칸 이동한다.
            // index1의 값이 더 큰 경우 index2의 값 저장 후 인덱스 이동
            if(tmp[index1]>tmp[index2]){
                A[k]=tmp[index2];
                k++;
                index2++;
            //index2의 값이 더 큰 경우 index1의 값을 저장 후 인덱스 이동
            }else{
                A[k]=tmp[index1];
                k++;
                index1++;
            }
        }
            //한쪽 그룹이 모두 선택된 후 남아있는 값 정리
            while(index1 <= medium){
                A[k]=tmp[index1];
                k++;
                index1++;
            }
            while(index2 <= end){
                A[k] = tmp[index2];
                k++;
                index2++;
            }
    }
}
