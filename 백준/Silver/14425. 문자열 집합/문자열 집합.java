import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        tNode root = new tNode();
        //트라아 자료구조 구축하기
        while(n>0){
            String text = sc.next();
            tNode now = root;
            for(int i = 0; i < text.length(); i++){
                char c = text.charAt(i);
                //26개의 알파벳의 위치를 배열 index로 나타내기 위해 -'a' 수행
                if(now.next[c-'a'] ==null){
                    now.next[c-'a'] = new tNode();
                }
                now = now.next[c-'a'];

                if(i==text.length()-1)
                    now.isEnd=true;
            }
            n--;
        }
        int count = 0;
        //트라이 자료구조 검색하기
        while(m>0){
            String text = sc.next();
            tNode now = root;
            for(int i = 0; i<text.length() ; i++){
                char c = text.charAt(i);
                //공백 노드라면 이 문자열을 포함하지 않는다.
                if(now.next[c-'a'] == null){
                    break;
                }
                now = now.next[c-'a'];
                //문자열의 끝이고 현재까지 모두 일치하면 S 집합에 포함되는 문자열이다.
                if(i==text.length()-1 && now.isEnd){
                    count ++;
                }
            }
            m--;
        }
        System.out.println(count);
    }
}
class tNode{
    tNode[] next = new tNode[26];
    //문자열의 마지막 유무 표시
    boolean isEnd;
}
