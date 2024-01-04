import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[]args){
        Scanner sc= new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int [N];

        for(int i = 0; i<N ; i++){
            A[i]=sc.nextInt();
        }

        Stack<Integer> stack = new Stack<>();
        StringBuffer bf = new StringBuffer();
        int num = 1;
        boolean result = true;

        for(int i = 0 ; i<A.length; i++){
            //현재수열
            int su = A[i];
            //자연수와 현재 수열 값이 같아질 때 까지 push()수행
            if(su>=num){
                while(su>=num){
                    stack.push(num++);
                    bf.append("+\n");
                }
                stack.pop();
                bf.append("-\n");
            }
            //현재 수열 값 < 오름차순 자연수일 경우
            //pop()을 수행하여 수열 원소를 꺼낸다.
            else{
                int n = stack.pop();
                //스택의 가장 위의 수가 만들어야 하는 수열의 수보다 크면 수열을 출력할 수 없다.
                if(n>su){
                    System.out.println("NO");
                    result=false;
                    break;
                }else {
                    bf.append("-\n");
                }
            }
        }
    if(result) System.out.println(bf.toString());
    }
}
