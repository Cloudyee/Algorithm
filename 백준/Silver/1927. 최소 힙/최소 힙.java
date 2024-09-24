import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //연산의 개수 N
        PriorityQueue minQueue = new PriorityQueue();
        int tmp;
        for(int i = 0 ; i<N ; i++){
            tmp = Integer.parseInt(br.readLine());

            if(tmp==0){
                if(minQueue.isEmpty()){
                    System.out.println(0);
                }else{
                    System.out.println(minQueue.poll());
                }
            }else{
                minQueue.add(tmp);
            }
        }
    }
}
