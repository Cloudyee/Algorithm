import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int sum = 0;
        int max = 0;
        int input = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N ; i++){
            input = Integer.parseInt(st.nextToken());
            sum+= input;
            if(max < input){
                max = input;
            }
        }

        System.out.println((sum*100.0)/max/N);
    }
}
