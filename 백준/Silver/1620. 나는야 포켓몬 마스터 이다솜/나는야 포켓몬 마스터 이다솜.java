import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //도감에 실린 포켓몬 수
        int N = Integer.parseInt(st.nextToken());
        //맞춰야할 포켓몬 수
        int M = Integer.parseInt(st.nextToken());
        
        //이름과 번호를 각각 두가지 map에 저장
        Map<String, Integer> dogamName = new HashMap<>();
        Map<Integer, String> dogamNumber = new HashMap<>();


        //도감에 입력
        for(int i = 1; i<=N ; i++) {
            String name = br.readLine();
            dogamNumber.put(i, name);
            dogamName.put(name, i);
        }

        String input;

        for(int i = 0; i<M ; i++){
            input = br.readLine();
            if(Character.isDigit(input.charAt(0))){
                System.out.println(dogamNumber.get(Integer.parseInt(input)));
            }else{
                System.out.println(dogamName.get(input));
            }
        }
    }
}
