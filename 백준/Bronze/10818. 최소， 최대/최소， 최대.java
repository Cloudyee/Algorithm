import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //입력 값 갯수
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int minNum = 1000001;
        int maxNum = -1000001;
        int temp = 0;
        for(int i = 0; i<N ; i++){
            temp = Integer.parseInt(st.nextToken());
            if(minNum > temp)
                minNum = temp;
            if(maxNum < temp)
                maxNum = temp;
        }
        System.out.println(minNum+" "+maxNum);
    }
}
