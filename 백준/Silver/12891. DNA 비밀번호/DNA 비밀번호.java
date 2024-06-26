import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int checkArr[];
    static int myArr[];
    static int checkSecret;

    //새로 들어온 문자를 처리하는 함수
    private static void Add(char c){
        switch (c) {
            case 'A':
                myArr[0]++;
                if (myArr[0] == checkArr[0])
                    checkSecret++;
                break;
            case 'C':
                myArr[1]++;
                if(myArr[1]==checkArr[1])
                    checkSecret++;
                break;
            case 'G':
                myArr[2]++;
                if(myArr[2]==checkArr[2])
                    checkSecret++;
                break;
            case 'T':
                myArr[3]++;
                if(myArr[3]==checkArr[3])
                    checkSecret++;
                break;
        }
    }

    //제거되는 문자 처리 함수
    private static void Remove(char c){
        switch (c){
            case 'A':
                if(myArr[0] ==checkArr[0])
                    checkSecret--;
                myArr[0]--;
                break;
            case 'C':
                if(myArr[1] ==checkArr[1])
                    checkSecret--;
                myArr[1]--;
                break;
            case 'G':
                if(myArr[2] ==checkArr[2])
                    checkSecret--;
                myArr[2]--;
                break;
            case 'T':
                if(myArr[3] ==checkArr[3])
                    checkSecret--;
                myArr[3]--;
                break;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        //문자열 길이
        int S = Integer.parseInt(st.nextToken());

        //부분 문자열 길이
        int P = Integer.parseInt(st.nextToken());

        int Result = 0;
        char A[] = new char[S];
        checkArr = new int[4];
        myArr = new int [4];

        A=bf.readLine().toCharArray();
        st=new StringTokenizer((bf.readLine()));
        for(int i = 0 ; i<4; i++){
            checkArr[i] = Integer.parseInt(st.nextToken());
            if(checkArr[i]==0)
                checkSecret++;
        }

        //P 부분 문자열 처리
        for(int i = 0 ; i<P; i++){
            Add(A[i]);
        }
        if(checkSecret == 4) Result++;

        //슬라이딩 윈도우 처리
        for(int i = P ; i<S; i++){
            int j = i-P;
            Add(A[i]);
            Remove(A[j]);
            //4자릿수와 관련된 크기가 모두 충족될 때 유효한 비밀번호로 카운트.
            if(checkSecret==4)
                Result++;
        }
        System.out.println(Result);
        bf.close();
    }
}
