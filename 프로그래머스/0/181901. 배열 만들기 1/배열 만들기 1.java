import java.util.*;

class Solution {
    public ArrayList<Integer>  solution(int n, int k) {
        ArrayList<Integer> answer = new ArrayList<>();
        int i = 1;
        while((i*k) <=n){
            answer.add(i*k);
            i++;
        }
        return answer;
    }
}