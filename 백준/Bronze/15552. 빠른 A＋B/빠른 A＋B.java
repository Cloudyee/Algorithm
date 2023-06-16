import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int num = Integer.parseInt(bf.readLine()); // 첫 입력값
		for (int i = 0; i < num; i++) { // 입력값 받기
            String s = bf.readLine();
			StringTokenizer st = new StringTokenizer(s);
			long a = Long.parseLong(st.nextToken());
			long b = Long.parseLong(st.nextToken());
			
			bw.write(String.valueOf(a+b));
            bw.newLine();
		}
        bw.flush();
	}
}
