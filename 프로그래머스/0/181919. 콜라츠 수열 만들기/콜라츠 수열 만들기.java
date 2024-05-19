import java.util.*;
class Solution {
    public int[] solution(int n) {
        ArrayList<Integer>answer = new ArrayList<Integer>();
        int num = n;
         answer.add(num);
    while(num>1){
        if(num%2==0){
            num=num/2;
        }else{
            num=3*num+1;    
        }
         answer.add(num);
    }
         // List<Integer>를 int[]로 변환
        return answer.stream().mapToInt(i -> i).toArray();
    }
}