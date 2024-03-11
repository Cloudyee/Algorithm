import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        //인덱스 저장
        int[] A = new int[10000001];

        //N의 범위까지 소수 구하기
        for (int i = 2; i < A.length; i++) {
            A[i] = i;
        }
        //제곱근 까지만 수행하기
        for (int i = 2; i < Math.sqrt(A.length); i++) {
            if (A[i] == 0) {
                continue;
            }

            //배수 지우기
            for (int j = i+i ; j < A.length; j = j + i) {
                A[j] = 0;
            }
        }


            int i = N;
            while (true) {
                //N부터 1씩 증가시키며 소수와 펠린드롬 수가 맞는지 확인
                if (A[i] != 0) {
                    int result = A[i];
                    //가장 먼저 펠린드롬인 == 가장 작은 펠린드롬 수를 찾으면 break
                    if (isPalindrome(result)) {
                        System.out.println(result);
                        break;
                    }
                }
                i++;
            }
    }

    //펠린드롬 수 판별 함수
    private static boolean isPalindrome(int target){
        //대상을 char배열로 변환
        char temp[] = String.valueOf(target).toCharArray();

        //투포인터를 활용하여 배열이 동일한지 판별
        int s = 0;
        int e = temp.length-1;
        while(s<e){
            if(temp[s] != temp[e])
                return false;
            s++;
            e--;
        }
        return true;
    }

}
