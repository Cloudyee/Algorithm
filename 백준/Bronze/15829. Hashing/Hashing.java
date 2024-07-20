import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //문자열의 길이
        int L = Integer.parseInt(st.nextToken());

        //문자열 입력
        String input = br.readLine();
        long MOD  = 1234567891;
        long answer = 0;

        //[체크] : Math.pow를 사용할 경우, 정밀도가 한정되어 있어 손실이 나타날 수 있다.
        long r = 31;
        long power = 1;  //r^0 = 1

        //각 항들의 숫자로 대치하여 저장
        for(int i = 0 ; i< L ; i++){
            answer = answer + (long) ((input.charAt(i) - 'a' + 1)*power%MOD);
            power  = (power*r)%MOD; //다음 거듭제곱을 위해 업데이트해준다.
        }
        System.out.println(answer%MOD);
    }
}
