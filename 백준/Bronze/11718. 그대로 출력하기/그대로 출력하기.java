import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> sent = new ArrayList<>();

        String str="";
        int lines = 0;
        while((lines<100) && (str=br.readLine())!=null){
            sent.add(str);
            lines++;
        }

        for(int i=0;i<sent.size();i++){
            System.out.println(sent.get(i));
        }
    }
}
