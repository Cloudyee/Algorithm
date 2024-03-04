import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //카드 묶음의 수
        int N = sc.nextInt();
        //우선순위 큐 활용
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0 ; i<N ; i++){
            int data = sc.nextInt();
            pq.add(data);
        }

        int data1 = 0;
        int data2 = 0;
        int sum = 0;
        //우선순이 큐의 남은 값이 1이 될 때 까지 반복
        while(pq.size()!=1){
            data1 = pq.remove();
            data2 = pq.remove();
            //적은 수로 경우의 수를 구하고
            sum+=data1+data2;
            //해당 수를 다시 우선순위 큐에 집어넣는다.
            pq.add(data1 + data2);
        }
        System.out.println(sum);
    }
}
