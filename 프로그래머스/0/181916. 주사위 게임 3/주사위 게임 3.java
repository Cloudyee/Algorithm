import java.util.*;
class Solution {
    public int solution(int a, int b, int c, int d) {
        //도저히 못풀어서 다른 분 풀이 들고옴....심각하다
        //정렬 후 조건문을 수행하여 해당 문제를 해결할 수 있다.
        int[] arr = {a,b,c,d};
        Arrays.sort(arr);
        a=arr[0]; b=arr[1]; c=arr[2]; d=arr[3];  // a~d를 낮은수부터 정렬
        
        //삼항연산자를 변환하여 경우를 계산해준다.
        return
        a==d      ? a*1111 :            // 네수가 같을 때
        a==c      ? (10*a+d)*(10*a+d) : // abc가 같을 때
        b==d      ? (10*b+a)*(10*b+a) : // bcd가 같을 때
        a==b&c==d ? c*c-a*a :           // 두개씩 두쌍이 같을 때
        a==b      ? c*d :               // ab가 같을 때
        b==c      ? a*d :               // bc가 같을 때
        c==d      ? a*b :               // cd가 같을 때
        a;                              // 모두 다를 때
    }
}