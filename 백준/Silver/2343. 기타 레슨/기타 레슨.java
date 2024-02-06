import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 레슨 수
        int N = sc.nextInt();
        //블루레이 개수
        int M =sc.nextInt();
        //기타 레슨 데이터 저장 배열
        int A [] = new int[N];
        //시작 인덱스 값
        int start = 0 ;
        //종료 인덱스 값
        int end = 0;
        
        //기타 레슨 값 저장
        for(int i = 0 ; i<N ; i++){
            A[i]=sc.nextInt();
            //레슨 최댓값을 시작 인덱스로 저장
            if(start<A[i]) start=A[i];
            //모든 레슨의 총합을 종료 인덱스로 저장
            end = end+A[i];
        }
        
        //start가 end보다 같거나 클 때 까지 반복
        while(start<=end){
            //중간 값
            int middle = (start+end)/2;
            //레슨의 합
            int sum = 0;
            //사용된 블루레이의 수
            int count = 0;
            
            //레슨의 수 만큼 반복
            for(int j = 0 ; j<N ; j++){
                //중간 값으로 모든 레슨을 저장할 수 있는지 확인
                    //중간 값으로 해당 레슨을 저장할 수 없는 경우
                if(sum+A[j]>middle){
                    //블루레이 갯수 추가
                    count ++;
                    sum = 0;
                }
                //레슨들의 합
                sum = sum+A[j];
            }
            //탐색 후 sum이 0이 아니라면 블루레이가 1개 더 필요하므로 count에 1을 더함
            if(sum != 0){
                count ++;
            }
            if(count > M){
                start = middle+1;
            }else{
                end = middle-1;
            }
        }
        System.out.println(start); 
    }
}
