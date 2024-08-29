import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        //[1] 배열을 정렬
        int[] peoples= people.clone();
        Arrays.sort(peoples);
        //투포인터를 활용한다.
        //가장 가벼운 사람
        int left = 0;
        //가장 무거운 사람
        int right = peoples.length-1;

        //최소 횟수를 더하는 변수
        int answer = 0;

        while(left <= right){
            //가장 가벼운 사람과 무거운 사람을 함께 보트에 태우는 경우
            if(peoples[left] + peoples[right] <= limit){
                left++;
            }
            /* 구명보트의 무게 제한은 항상 사람들의 몸무게 중 최댓값보다 크게 주어지므로 사람들을 구출할 수 없는 경우는 없습니다.
            * : 해당 경우는 생각하지 않는다.*/
            right--;
            answer++;
        }
        return answer;
    }
}