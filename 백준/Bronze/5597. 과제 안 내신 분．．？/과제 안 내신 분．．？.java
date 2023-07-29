import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        //숫자를 미리 저장해둔 배열(인덱스 1부터 30까지 사용)ㄴ
        int [] students = new int [31];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력된 숫자의 배열 부분에 1 저장(2명 덜 제출하므로 0~27)
        for(int i = 0; i<28 ; i++){
            int submit = Integer.parseInt(br.readLine());
            students[submit]=1;
        }

        //미제출 학생 출력
        for(int i=1; i<students.length; i++){
            if(students[i] !=1){
                System.out.println(i);
            }
        }
        br.close();
        //--- Scanner 사용해서 풀어봄
//        Scanner sc = new Scanner(System.in);
//        int[] students = new int[30];
//        for(int i =0; i<28;i++){
//            int submit = sc.nextInt();
//            students[submit]=1;
//        }
//        for(int i = 0; i<30; i++){
//            if(students[i]!=1){
//                System.out.println(i);
//            }
//        }
//        sc.close();
//    }
    }

}
