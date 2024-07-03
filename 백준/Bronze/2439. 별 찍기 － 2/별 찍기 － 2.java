import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        for(int i = 1 ; i<=N ; i++){
            for(int j = N-i; j>0 ; j--){
                System.out.print(" ");
            }
            for(int k = i ; k>0 ; k--){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
