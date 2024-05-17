class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        StringBuilder add = new StringBuilder();
        StringBuilder odd = new StringBuilder();

        for (int i = 0; i < num_list.length; i++) {
            if (num_list[i] % 2 == 0)
                add.append(num_list[i]);
            else
                odd.append(num_list[i]);
        }
        
        answer=Integer.parseInt(add.toString())+ Integer.parseInt(odd.toString());
        return answer;
    }
}