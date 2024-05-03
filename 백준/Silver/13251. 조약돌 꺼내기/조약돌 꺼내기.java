import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int M, K, T;
        int D[] = new int[51];
        double probability [] = new double[51];
        double answer;
        T=0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i<M ; i++){
            D[i] = Integer.parseInt(st.nextToken());
            T+=D[i];
        }
        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        answer = 0.0;
        for(int i = 0 ; i<M ; i++){
            if(D[i]>=K){
                probability[i] = 1.0;
                for(int k = 0; k<K ; k++){
                    probability[i] *=(double)(D[i]-k)/(T-k);
                }
                answer+=probability[i];
            }
        }
            System.out.println(answer);
    }
}
