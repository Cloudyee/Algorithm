import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder result=new StringBuilder();
        for (int i = 0 ; i<8 ; i++){
            result.append(st.nextToken());
        }

        if(result.toString().equals("12345678")){
            System.out.println("ascending");
        }else if(result.toString().equals("87654321")){
            System.out.println("descending");
        }else{
            System.out.println("mixed");
        }
    }
}
