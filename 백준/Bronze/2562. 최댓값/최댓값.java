import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int maxNum = 0;
        int maxNumIdx = 0;
        for(int i = 0 ; i<9 ; i++){
            int read = Integer.parseInt(br.readLine());
            if(maxNum < read){
                maxNum = read;
                maxNumIdx = i;
            }
        }
        System.out.println(maxNum);
        System.out.println(maxNumIdx+1);
    }
}
