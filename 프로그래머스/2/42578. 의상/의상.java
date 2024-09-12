import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
       //수학적 사고로 풀 수 있는 문제였다.
        //경우의 수 1) 의상이 하나인 경우의 수 -> 하나만 입는 경우 & 안입는 경우
        //경우의 수 2) 의상이 두개인 경우 -> (하나만 입는 경우 & 안입는 경우)(하나만 입는 경우 & 안입는 경우) - 두가지 모두 안입는 경우
        Map<String, Integer> map = new HashMap<>();
        for(String[] clothe : clothes){
            //의상의 종류: key 
            //해당 key를 가질 경우 경우의 수를 ++ 
            if(map.containsKey(clothe[1])){
               map.put(clothe[1], map.get(clothe[1]) + 1);
            }else{
                map.put(clothe[1], 1);
            }
        }
        
       int answer = 1;
       
        for(String key : map.keySet()){
            //위의 공식을 적용하여 (a+1)(b+1)...(n+1)-1 연산을 수행
            answer = answer * (map.get(key) + 1);
        }
        answer -= 1;
        return answer;
    }
}