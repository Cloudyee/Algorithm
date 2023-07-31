import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String output = "";
		char tmp;
		
		for(int i = 0; i<input.length(); i++) {
			tmp = (char)input.charAt(i);
			if(Character.isLowerCase(tmp)) {
				output+=Character.toUpperCase(tmp);
			}else {
				output+=Character.toLowerCase(tmp);
			}
		}
		System.out.println(output);
		
	}
}
