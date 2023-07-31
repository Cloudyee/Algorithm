import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 갯수 정하는 T
        int T = Integer.parseInt(br.readLine());
        ArrayList<String> sentences = new ArrayList<>();
        for(int i = 0; i<T ; i++){
            sentences.add(br.readLine());
        }
        ArrayList<String> selected = new ArrayList<>();
        for(int i = 0; i<T ; i++){
            char first = sentences.get(i).charAt(0);
            char last = sentences.get(i).charAt(sentences.get(i).length()-1);
            System.out.println(Character.toString(first)+Character.toString(last));
        }
    }
}
