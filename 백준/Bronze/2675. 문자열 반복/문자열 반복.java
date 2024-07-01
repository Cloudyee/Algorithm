import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int N = Integer.parseInt(br.readLine()); //입력 값 갯수

        for(int i = 0 ; i<N ; i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            String[] strings = st.nextToken().split("");
            for(int j = 0 ; j< strings.length ; j++){
                for(int k = 0 ; k<num ; k++){
                    System.out.print(strings[j]);
                }
            }
            System.out.println();
        }
    }
}
