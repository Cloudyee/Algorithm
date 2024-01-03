
import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static final Scanner scanner = new Scanner(System.in);

    //LinkedList로 활용하기 위한 Node class
    static class Node{
        public int value;
        public int index;

        Node(int value, int index){
            this.value=value;
            this.index=index;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //출력을 버퍼에 넣고 한번에 출력할 것이다.
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st= new StringTokenizer(br.readLine());

        //데이터 개수
        int N=Integer.parseInt(st.nextToken());

        //계산 범위
        int L = Integer.parseInt(st.nextToken());

        st=new StringTokenizer(br.readLine());
        Deque<Node> mydeque = new LinkedList<>();
        for(int i=0 ;i<N; i++){
            int now = Integer.parseInt(st.nextToken());

            //새로운 값이 들어올때 마다 현재 수보다 큰 값을 덱에서 제거
            while(!mydeque.isEmpty() && mydeque.getLast().value >now){
                mydeque.removeLast();
            }
            mydeque.add(new Node(now, i));

            //범위에서 벗어난 값 제거
            if(mydeque.getFirst().index <= i-L){
                mydeque.removeFirst();
            }
            bw.write(mydeque.getFirst().value+" ");
        }
        bw.flush();
        bw.close();
    }
}
