import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		if(m%4==0 && (m%400==0 || m%100 != 0)) {
			System.out.println(1);
		}else {
			System.out.println(0);
		}
	}
}
