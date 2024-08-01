import java.util.*;

class Solution {
    public int solution(int[] numbers, int target) {
        //기초적인 발상을 해내지 못해 다른분의 풀이를 참고했다.... 응용할 수 있도록 연습할 것
        
        //배열의 숫자를 더하거나 빼는 두 가지 선택지를 **재귀적으로** 탐색
        //목표값과 일치하는 경우를 찾아 경우의 수를 ++
        
        
        return dfs(0, numbers, target , 0);
    }
    
    private int dfs(int depth, int[] numbers, int target, int sum){
        //모든 숫자를 다 사용한 경우
        if(depth == numbers.length)
            //현재의 합이 목표 값과 일치하는지 확인
            return sum == target ? 1 : 0;
        /*
        재귀적으로 값을 더하는 경우, 빼는 경우를 DFS로 탐색
        sum = target인 경우가 발견될 때마다 1을 반환한다.
        모든 가지가 탐색되면, 각각의 결과가 더해져 최종 답이된다.
        */
        return dfs(depth+1, numbers, target , sum+numbers[depth]) + dfs(depth+1, numbers, target, sum-numbers[depth]);
    }
}