class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        int first= Integer.parseInt(a+""+b);
        int second=Integer.parseInt(b+""+a);
        if(first>second){
            answer=first;
        }else{
            answer=second;
        }
        return answer;
    }
}