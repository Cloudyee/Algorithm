import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String temp = "";
        while(true){
            temp = br.readLine();
            if(temp.equals("0"))
                break;

            boolean isPalindrome = true;
            for(int i = 0 ; i<temp.length()/2; i++){
                if(temp.charAt(i) != temp.charAt(temp.length()-i-1)){
                    isPalindrome = false;
                    break;
                }
            }
            if(isPalindrome == true){
                System.out.println("yes");
            }else{
                System.out.println("no");
            }
        }
    }
}
