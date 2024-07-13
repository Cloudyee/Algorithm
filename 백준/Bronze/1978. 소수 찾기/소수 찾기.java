import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //수의 개수
        int N = Integer.parseInt(st.nextToken());
        int[] inputs = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            inputs[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(countPrimes(inputs));
    }

    private static int countPrimes(int[] numbers){
        int count = 0;
        for(int number : numbers){
            if(isPrime(number)){
                count ++;
            }
        }

        return count;
    }

    private static boolean isPrime(int number){
        if(number<=1)
            return false;
        for(int i = 2; i*2 <=number ; i++){
            if(number % i == 0)
                return false;
        }
        return true;
    }
}

