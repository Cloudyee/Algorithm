class Solution {
    public int solution(String number) {
        int sumDigit = 0;
        for(int i = 0 ; i<number.length(); i++){
            sumDigit+= number.charAt(i)-'0'; //문자 숫자를 정수로 변환
        }
        return sumDigit % 9;
    }
}