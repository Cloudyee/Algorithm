import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {      
        //* 노드를 활용하여 현재 단어와 단계수를 저장한다.
        //너비 우선 탐색을 시작한다.

        int answer = 0;

        //BFS를 위한 Queue초기화
        Queue<Node> queue = new LinkedList<>();
        //시작단어와 0단계를 큐에 추가한다.
        queue.add(new Node(begin, 0));

        //방문 여부 체크
        // 이미 탐색한 단어는 다시 탐색하지 않는다.
        boolean[] visited = new boolean[words.length];

        while(!queue.isEmpty()){
            Node currentNode = queue.poll();
            String currentWord = currentNode.word;
            int currentCount = currentNode.count;

            //타겟 단어를 찾으면 변환 단계를 반환한다.
            if(currentWord.equals(target)){
                answer = currentCount;
                break;
            }

            //모든 단어를 순회하며 변환 가능성을 검사
            for(int i = 0 ; i<words.length ; i++){
                if(!visited[i] && transFormPossible(currentWord , words[i])){
                    visited[i] =true;
                    queue.add(new Node(words[i] , currentCount+1));
                }
            }

        }
        return answer;
    }
    
    //대상 글자와 한글자만 차이 나는 것인지 확인
    static boolean transFormPossible(String currentWord, String diffWord){
        int diffCount = 0;
        //문자를 순회하며 글자를 확인
        for(int i = 0 ; i<currentWord.length() ; i++){
            if(currentWord.charAt(i) != diffWord.charAt(i)){
                if(++diffCount > 1)
                    return false;
            }
        }

        return true;
    }

    //큐에 저장할 현재단어와 변환단계
    class Node{
        String word;        //현재 단계 단어
        int count;          //변환 단계

        public Node(String word, int count){
            this.word = word;
            this.count = count;
        }
    }
}