import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class mData implements Comparable<mData>{
    int value;
    int index;
    public mData(int value, int index){
        super();
        this.value = value;
        this.index = index;
    }

    //value 기준 오름차순 정렬
    @Override
    public int compareTo(mData o) {
        return this.value-o.value;
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        mData[] A = new mData[N];

        //입력 값 저장
        for(int i = 0; i<N ; i++){
            A[i] = new mData(Integer.parseInt(reader.readLine()),i);
        }
        //A 배열 정렬
        Arrays.sort(A);

        int Max = 0;
        for(int i = 0 ; i<N ; i++){
            //정렬 전 index - 정렬 후 index
            if(Max < A[i].index - i){
                Max = A[i].index-i;
            }
        }
        System.out.println(Max+1);
    }
}
