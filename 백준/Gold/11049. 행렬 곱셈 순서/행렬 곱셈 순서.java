import java.util.Scanner;

public class Main {
    static int N;
    static Matrix[] M;
    static int[][] D;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = new Matrix[N+1];
        D = new int[N+1][N+1];

        for(int i = 0 ; i< D.length ; i++){
            for(int j = 0 ; j<D[i].length ; j++){
                D[i][j] = -1; //배열 -1로 초기화
            }
        }

        for(int i = 1 ; i<= N ; i++){
            int y = sc.nextInt();
            int x = sc.nextInt();
            M[i] = new Matrix(y , x);
        }
        System.out.println(excute(1, N));
    }
    //톱-다운 방시긍로 저모하식 함수 구현
    static int excute(int s , int e){
        int result = Integer.MAX_VALUE;
        if(D[s][e] != -1) //계산했던 부분이면 다시 계산하지 않음(메모이제이션)
            return D[s][e];
        if(s==e)//행렬 1개의 곱셈 연산의 수
            return 0;
        if(s+1 ==e) //행렬 2개의 곱셈 연산의 수
            return M[s].y * M[s].x * M[e].x;
        for(int i = s; i<e ; i++){
            //행렬이 3개 이상일 때 곱셈 연산 수 = 점화식 처리
            result = Math.min(result, M[s].y * M[i].x * M[e].x + excute(s, i)+excute(i+1, e));
        }
        return D[s][e] =result;
    }
    //행렬 정보 저장
    static class Matrix{
        private int y;
        private int x;

        Matrix(int y , int x){
            this.y = y;
            this.x = x;
        }
    }
}
