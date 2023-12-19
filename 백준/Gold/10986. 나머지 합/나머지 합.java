import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        
        // 수열의 개수
        int N = sc.nextInt();
        // 나누어 떨어지는 수
        int M = sc.nextInt();
        
        long[] S = new long[N]; // 수정: 배열 크기를 N으로 변경
        long[] C = new long[M];
        long answer = 0;
        S[0] = sc.nextInt();
        
        // 수열 합 배열 만들기
        for (int i = 1; i < N; i++) {
            S[i] = S[i - 1] + sc.nextInt();
        }
        
        // 합 배열의 모든 값에 % 연산 수행
        for (int i = 0; i < N; i++) {
            int remainder = (int) (S[i] % M);
            // 구간합이 0일 때 정답에 더해주기
            if (remainder == 0) answer++;
            // 나머지가 같은 인덱스 수 카운팅
            C[remainder]++;
        }
        
        for (int i = 0; i < M; i++) {
            // 나머지가 같은 인덱스 중 2개를 뽑는 경우의 수 더하기
            if (C[i] > 1) {
                answer = answer + (C[i] * (C[i] - 1) / 2);
            }
        }
        System.out.println(answer);
        
        // 수정: Scanner 닫기
        sc.close();
    }
}
