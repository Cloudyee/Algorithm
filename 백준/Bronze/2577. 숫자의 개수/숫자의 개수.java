import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        int num = A*B*C;
        String strNum = num+"";
        int[] result = new int [10];

        for(int i = 0; i<10; i++){
            for(int j = 0 ; j<strNum.length() ; j++){
                if(Integer.parseInt(strNum.charAt(j)+"") == i){
                    result[i]+=1;
                }
            }
        }

        for(int ans : result){
            System.out.println(ans);
        }
    }
}
