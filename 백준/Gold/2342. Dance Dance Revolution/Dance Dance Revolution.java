import java.util.Scanner;

public class Main {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      // dp[s][l][r] = s번째 수열까지 수행했고, 왼발이 l, 오른발이 r 위치에 있을 때 최소 누적 힘
      int dp[][][] = new int[100001][5][5];
      // 한 발을 이동할 때 드는 힘을 미리 지정하기 (mp[1][2] = 1에서 2로 이동할 때 드는 힘)
      int mp[][] = {
              {0, 2, 2, 2, 2},
              {2, 1, 3, 4, 3},
              {2, 3, 1, 3, 4},
              {2, 4, 3, 1, 3},
              {2, 3, 4, 3, 1}
      };
      int n = 0;  // 현재 밟을 발판 번호
      int s = 1;  // 현재 단계

      // dp 배열 초기화
      for (int i = 0; i < 5; i++) {
         for (int j = 0; j < 5; j++) {
            for (int k = 0; k < 100001; k++) {
               dp[k][i][j] = 100001 * 4; // 충분히 큰 수로 초기화
            }
         }
      }
      dp[0][0][0] = 0;  // 초기 상태, 아무것도 밟지 않은 상태에서 힘은 0

      while (true) {
         n = sc.nextInt();
         if (n == 0) break; // 입력의 마지막이면 종료
         // 왼발은 그대로 두고 오른발을 옮기는 경우
         for (int i = 0; i < 5; i++) {
            if (n == i) continue; // 두 발이 같은 자리에 있을 수 없다.
            for (int j = 0; j < 5; j++) {
               // 오른발을 옮겨 현재의 모습이 됐을 때 최소의 힘 저장하기
               dp[s][i][n] = Math.min(dp[s-1][i][j] + mp[j][n], dp[s][i][n]);
            }
         }
         // 오른발은 그대로 두고 왼발을 옮기는 경우
         for (int j = 0; j < 5; j++) {
            if (n == j) continue; // 두 발이 같은 자리에 있을 수 없다.
            for (int i = 0; i < 5; i++) {
               // 왼발을 옮겨 현재의 모습이 됐을 때 최소의 힘 저장하기
               dp[s][n][j] = Math.min(dp[s-1][i][j] + mp[i][n], dp[s][n][j]);
            }
         }
         s++;
      }
      s--;  // 마지막 입력 처리된 상태에서 단계 감소
      int min = Integer.MAX_VALUE;
      
      for (int i = 0; i < 5; i++) {
         for (int j = 0; j < 5; j++) {
            min = Math.min(min, dp[s][i][j]); // 모든 경우 중 최솟값 찾기
         }
      }
      System.out.println(min);
   }
}
