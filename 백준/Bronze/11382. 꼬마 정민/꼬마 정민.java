import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] inputs = br.readLine().split(" ");
		Long a = Long.parseLong(inputs[0]);
		Long b = Long.parseLong(inputs[1]);
		Long c = Long.parseLong(inputs[2]);
		
		System.out.println(a+b+c);

	}
}