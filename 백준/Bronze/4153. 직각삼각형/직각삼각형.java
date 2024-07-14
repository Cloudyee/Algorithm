import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int [] inputs;
        for(int i = 0; i<Integer.MAX_VALUE; i++) {
            st = new StringTokenizer(br.readLine());
            inputs = new int[3];

            int first = Integer.parseInt(st.nextToken());

            if (first == 0)
                break;

            inputs[0] = first;
            inputs[1] = Integer.parseInt(st.nextToken());
            inputs[2] = Integer.parseInt(st.nextToken());

            Arrays.sort(inputs);
            System.out.println(isRight(inputs));
        }

    }

    private static String isRight(int[] inputs){
        for(int i = 0 ; i<3 ; i++){
          if(Math.pow(inputs[0], 2) + Math.pow(inputs[1], 2) == Math.pow(inputs[2], 2))
              return "right";
        }
        return "wrong";
    }
}
