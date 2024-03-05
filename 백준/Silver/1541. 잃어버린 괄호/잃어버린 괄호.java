import java.util.Scanner;

public class Main {
    static int answer = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String example = sc.nextLine();
        //입력 식을 -를 기준으로 분리한다.
        String[] str = example.split("-");
        for(int i = 0; i< str.length ; i++){
            int temp = mySum(str[i]);
            if(i==0)
                //가장 앞에 있는 값만 더함
                answer=answer+temp;
            else
                //뒷부분은 더한 값들을 뺌
                answer=answer-temp;
        }
        System.out.println(answer);
    }

    //나뉜 그룹의 더하기 연산 수행 함수
    static int mySum(String a){
        int sum = 0;
        String temp [] = a.split("[+]");
        for(int i = 0; i<temp.length ; i++){
            sum+=Integer.parseInt(temp[i]);
        }
        return sum;
    }
}
