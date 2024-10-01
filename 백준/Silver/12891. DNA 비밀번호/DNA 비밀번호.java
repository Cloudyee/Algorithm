import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    //각 A, C, G, T의 최소개수가 저장됨
    static int[] checkArr;   //체크할 배열(동일한 알파벳 개수)
    static int[] nowArr;     //현재 배열(동일한 알파벳 개수)
    static int secretCount;  //비밀번호 동일 개수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken()); //민호가 임의로 만든 DNA 문자열 길이
        int P = Integer.parseInt(st.nextToken()); //비밀번호로 사용할 부분문자열의 길이
        int result = 0;

        //입력받을 DNA문자열
        char inputs[] = new char[S];
        inputs = br.readLine().toCharArray();

        checkArr = new int[4];
        nowArr = new int[4];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < 4 ; i++){
            checkArr[i] = Integer.parseInt(st.nextToken());
            // [예외처리] 해당 문자 개수가 0일 경우,
            // 모든 경우가 값 충족이기 떄문에 
            // 개수 충족 판단 변수 값 증가
            if(checkArr[i] == 0)
                secretCount++;
        }
        
        //초기 길이 P까지의 처리
        for(int i = 0 ; i < P ; i++){
            add(inputs[i]);
        }

        //네 글자 모두 충족하는 경우 결과값(경우의 수) 증가
        if(secretCount == 4){
            result++;
        }

        //**********************************
        //슬라이딩 윈도우 처리 **변수 활용에주의**
        //**********************************
        for(int i = P ; i < S ; i++){
            int j = i - P;
            //더해진 값은 더하고
            //그 이전의 값은 제외하는 연산 수행
            add(inputs[i]);
            remove(inputs[j]);
            //조건이 충족될 경우
            if(secretCount == 4)
                result++;
        }
        
        //조건 충족 경우의 수 출력
        System.out.println(result);
        br.close();
    }

    //**새로 들어온 문자를 처리하는 함수
    private static void add(char c){
        switch (c) {
            case 'A':
                nowArr[0]++;
                if (nowArr[0] == checkArr[0])
                    secretCount++;
                break;
            case 'C':
                nowArr[1]++;
                if (nowArr[1] == checkArr[1])
                    secretCount++;
                break;
            case 'G':
                nowArr[2]++;
                if (nowArr[2] == checkArr[2])
                    secretCount++;
                break;
            case 'T':
                nowArr[3]++;
                if (nowArr[3] == checkArr[3])
                    secretCount++;
                break;
        }
    }

    //**제거되는 문자를 처리하는 함수
    private static void remove(char c){
        switch (c){
            case 'A':
                if(nowArr[0] == checkArr[0])
                    secretCount--;
                nowArr[0]--;
                break;
            case 'C':
                if(nowArr[1] == checkArr[1])
                    secretCount--;
                nowArr[1]--;
                break;
            case 'G':
                if(nowArr[2] == checkArr[2])
                    secretCount--;
                nowArr[2]--;
                break;
            case 'T':
                if(nowArr[3] == checkArr[3])
                    secretCount--;
                nowArr[3]--;
                break;
        }
    }
}
