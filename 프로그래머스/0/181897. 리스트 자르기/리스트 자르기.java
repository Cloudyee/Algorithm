import java.util.*;

class Solution {
    public int[] solution(int n, int[] slicer, int[] num_list) {
        List<Integer> answer = new ArrayList<>();
        
        int a = slicer[0];
        int b = slicer[1];
        int c = slicer[2];

        if (n == 1) {
            // 0번 인덱스부터 b번 인덱스까지
            for (int i = 0; i <= b; i++) {
                answer.add(num_list[i]);
            }
        } else if (n == 2) {
            // a번 인덱스부터 마지막 인덱스까지
            for (int i = a; i < num_list.length; i++) {
                answer.add(num_list[i]);
            }
        } else if (n == 3) {
            // a번 인덱스부터 b번 인덱스까지
            for (int i = a; i <= b; i++) {
                answer.add(num_list[i]);
            }
        } else if (n == 4) {
            // a번 인덱스부터 b번 인덱스까지 c 간격으로
            for (int i = a; i <= b; i += c) {
                answer.add(num_list[i]);
            }
        }

        // List<Integer>를 int[]로 변환
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
