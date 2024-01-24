import java.io.*;

public class Main {
    public static int [] A;
    public static long result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //입력값 갯수
        int N = Integer.parseInt(br.readLine());
        A = new int[N];

        for(int i= 0 ; i<N ; i++){
            A[i] = Integer.parseInt(br.readLine());
        }
        br.close();

        RadixSort(A,5);
        for(int i = 0; i<N ; i++){
            bw.write(A[i]+"\n");
        }
        bw.flush();
        bw.close();
    }

    public static void RadixSort(int[] A, int max_size){
        int[]output = new int[A.length];
        int jarisu=1;
        int count=0;
        //최대 자리수만큼 반복
        while(count != max_size){
            int[]bucket = new int[10];
            for(int i = 0; i<A.length; i++){
                //1의 자리부터 시작하기
                bucket[(A[i] / jarisu)%10]++;
            }
            //합 배열을 이용하여 index rPtks
            for(int i = 1; i<10; i++){
                bucket[i]+=bucket[i-1];
            }
            //현재 자릿수를 기준으로 정렬
            for(int i = A.length-1;i>=0; i-- ){
                output[bucket[(A[i]/jarisu%10)]-1]=A[i];
                bucket[(A[i]/jarisu)%10]--;
            }
            //다음 자릿수를 이동하기 위해 현재 자릿수 기준 정렬 데이터를 저장
            for(int i = 0 ; i<A.length;i++){
                A[i] = output[i];
            }

            //자릿수 증가
            jarisu = jarisu*10;
            count++;
        }
    }

}
