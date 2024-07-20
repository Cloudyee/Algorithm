import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int count = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //명령의 수
        int N = Integer.parseInt(st.nextToken());
        String order ;
        long stack [] = new long [N];
        for(int i = 0 ; i<N ; i++){
            st = new StringTokenizer(br.readLine());
            order = st.nextToken();
            
            if(order.equals("push")){
                push(stack, Integer.parseInt(st.nextToken()));
            }else if(order.equals("pop"))
                pop(stack);
            else if(order.equals("size"))
                size();
            else if(order.equals("empty"))
                empty();
            else if(order.equals("top"))
                top(stack);
        }
    }

    private static long[] push(long[] numbers, int num){
        numbers[++count] = num;
        return numbers;
    }

    private static long[] pop (long[] numbers){
        long answer = -1;
        if(count > -1){
            answer = numbers[count];
            numbers[count] = -1;
            count --;
        }

        System.out.println(answer);
        return numbers;
    }

    private static void size(){
        System.out.println(count+1);
    }

    private static void  empty(){
        if(count == -1)
            System.out.println(1);
        else
            System.out.println(0);
    }

    private static void top(long[] numbers){
        if(count > -1)
            System.out.println(numbers[count]);
        else
            System.out.println(-1);
    }
}
