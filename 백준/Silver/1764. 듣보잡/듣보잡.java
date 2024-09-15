import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //듣도 못한 사람의 수
        int N = Integer.parseInt(st.nextToken());
        //보도 못한 사람의 수
        int M = Integer.parseInt(st.nextToken());

       Set inputs = new HashSet();
       List<String> dudBoZap = new ArrayList<>();
       String temp;


        for(int i = 0 ; i < N  ; i++){
            temp = br.readLine();
            inputs.add(temp);
        }

        for(int i = 0 ; i < M  ; i++){
            temp = br.readLine();

            if(inputs.contains(temp)){
                dudBoZap.add(temp);
            }
        }

        Collections.sort(dudBoZap);
        System.out.println(dudBoZap.size());
        for(String dubos : dudBoZap)
            System.out.println(dubos);;
    }
}
