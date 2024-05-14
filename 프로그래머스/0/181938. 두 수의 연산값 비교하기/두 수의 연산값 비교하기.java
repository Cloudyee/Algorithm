class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        int one = Integer.parseInt(""+a+b);
        int two = 2*a*b;
        answer= one>=two ? one : two;
        return answer;
    }
}