import java.util.Stack;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        //수열 배열 생성
        int[]A = new int [n];
        //정답 배열 생성
        int[]ans = new int[n];
        String[]str= bf.readLine().split(" ");
        for(int i = 0 ; i<n; i++){
            A[i] = Integer.parseInt(str[i]);
        }
        Stack<Integer> myStack = new Stack<>();
        //처음에는 항상 스택이 비어있으므로, 최소 값을 push해 초기화
        myStack.push(0);
        
        for(int i =1; i<n; i++){
        // 스태이 비어 있지 않고 현재 수열이 스택 top 인덱스가 가리키는 수열보다 큰 경우
            while(!myStack.isEmpty() && A[myStack.peek()]<A[i]){
                //정답 배열에 오큰수를 현재 수열로 저장
                ans[myStack.pop()]=A[i];
            }
        myStack.push(i);
        }
        while(!myStack.empty()){
            //반복문이 완료되었는데 스택이 비어있지 않다면 빌 때 까지 반족
            ans[myStack.pop()]=-1;
            //스택에 쌓인 index에 -1을 넣고
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 0; i<n; i++){
            //출력
            bw.write(ans[i] + " ");
        }
        bw.write("\n");
        bw.flush();
    }
}