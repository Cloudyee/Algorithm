import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> namoji = new ArrayList<>();
        for(int i = 0 ; i<10 ; i++){
            namoji.add(Integer.parseInt(br.readLine()) % 42);
        }
        List<Integer> results = new ArrayList<>();
        for(int result : namoji){
            if(! results.contains(result)){
                results.add(result);
            }
        }

        System.out.println(results.size());
    }
}
