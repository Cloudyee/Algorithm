import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        List<Integer> stk = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stk.isEmpty() && stk.get(stk.size() - 1) >= arr[i]) {
                stk.remove(stk.size() - 1);
            }
            stk.add(arr[i]);
        }
        return stk.stream().mapToInt(i -> i).toArray();
    }
}
