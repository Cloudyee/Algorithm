import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //큐 활용
        Queue<Integer> myQeue = new LinkedList<>();

        //카드의 장 수
        int N = sc.nextInt();

        //카드를 큐에 저장
        for(int i = 1 ; i <= N ; i++){
            myQeue.add(i);
        }

        //카드가 1장 남을 때 까지 반복
        while(myQeue.size() > 1){
            //맨 위의 카드를 버림
            myQeue.poll();
            //맨 위의 카드를 가장 아래 카드 밑으로 이동
            myQeue.add(myQeue.poll());
        }
        //마지막으로 남은 카드 출력
        System.out.println(myQeue.poll());
    }
}
