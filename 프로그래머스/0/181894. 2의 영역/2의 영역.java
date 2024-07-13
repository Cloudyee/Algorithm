class Solution {
    public int[] solution(int[] arr) {
        int start = -1;
        int end = -1;

        // Find the first and last occurrences of 2
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 2) {
                if (start == -1) {
                    start = i;
                }
                end = i;
            }
        }

        // If no 2 is found, return [-1]
        if (start == -1) {
            return new int[]{-1};
        }

        // Create the subarray from start to end
        int[] answer = new int[end - start + 1];
        for (int i = start; i <= end; i++) {
            answer[i - start] = arr[i];
        }

        return answer;
    }
}