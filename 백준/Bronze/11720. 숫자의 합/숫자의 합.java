import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String sNum = br.readLine();
        char[] cNum = sNum.toCharArray();
        int sum=0;
        for(int i = 0; i<cNum.length;i++){
            sum+=cNum[i] - '0'; //cNum[i]를 정수형으로 변환, sum에 더하며 누적
        }
        System.out.println(sum);
    }
}
