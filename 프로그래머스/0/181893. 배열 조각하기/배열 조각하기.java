import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[] query) {
       List<Integer> list = new ArrayList<>();
        for (int num : arr) {
            list.add(num);
        }

        for (int i = 0; i < query.length; i++) {
            int q = query[i];
            if (i % 2 == 0) {
                // Even index: keep elements from start to query[i] (inclusive)
                list = new ArrayList<>(list.subList(0, q + 1));
            } else {
                // Odd index: keep elements from query[i] (exclusive) to the end
                list = new ArrayList<>(list.subList(q, list.size()));
            }
        }

        // Convert list back to an array
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}