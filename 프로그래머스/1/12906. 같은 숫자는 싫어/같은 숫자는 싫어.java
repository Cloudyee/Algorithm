import java.util.*;

public class Solution {
    public int[] solution(int []arr) {       
        Stack<Integer> test = new Stack<>();
        for(int num : arr){
            if(test.empty() || test.peek() != num)
                test.push(num);
        }
        return test.stream().mapToInt(Integer::intValue).toArray();
    }
}