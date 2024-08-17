import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
       //n: 전체 학생 수 , lost : 도난당한 학생 번호 , reserve : 여벌 체육복 학생
        //아이디어를 더 빨리 떠올리도록 하자....
        /* 로직 정리
         * [1] 학생들의 배열 생성 , 처음에는 각자 체육복을 가짐 = 1
         * [2] 도난당한 학생 번호에 -1 == 0이 됨
         * [3] 여분 체육복을 가진 학생에 +1
         * [4] 체육복이 2개인 학생의 앞 뒤로 0이 있을 경우
         * 해당 학생 -1 ,0인 학생 +1
         */
        int answer = 0;
        int [] students = new int[n];
        //** 해당 함수 기억하기
        //[1] 학생들은 처음에 모두 자신의 체육복 1을 갖는다.
        Arrays.fill(students, 1);
        
        //[2] 도난당한 학생 번호의 체육복 감소
        for (int i = 0; i<lost.length; i++){
            students[lost[i] - 1] -= 1;
        }

        //[3] 여분 체육복을 가진 학생 번호의 체육복 증가
        for(int i = 0 ; i<reserve.length ; i++){
            students[reserve[i] -1 ] +=1;
        }

        //학생배열을 순회
        for(int i = 0 ; i<n ; i++){
            //[4] 여벌 체육복이 있는 경우
            if(students[i] == 2){
                //(1) 앞 학생의 체육복이 없을 경우
                if(i-1 >=0 && students[i-1] == 0){
                    students[i-1] +=1;
                    students[i] -=1;
                    //(2) 뒤 학생의 체육복이 없을 경우
                }else if(i+1<n && students[i+1]==0){
                    students[i+1]+=1;
                    students[i]-=1;
                }
            }
        }

        //체육복을 가진 학생 수 계산
        for(int student : students){
            if(student>0)
                answer++;
        }
        return answer;

    }
}