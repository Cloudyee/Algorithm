import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //입력받을 단어의 수
        int N = Integer.parseInt(st.nextToken());
        String inputs[] = new String[N];

        for(int i = 0; i<N ; i++){
            inputs[i] = br.readLine();
        }
        sorting(inputs);
    }

    private static String sorting(String[] inputs){
        String [] results = new String[inputs.length];
        //[중요] 배열을 특정한 규칙에 의해 정렬하고 싶을 경우 Comparator를 구현하면 된다!!!
        Arrays.sort(inputs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                //정렬 방법을 구현한다.
                /*
                * 기본적으로 compare 메소드는 3가지 리턴값에 의해 위치를 결정한다.
                * - 양의 정수
                * - 0
                * - 음의 정수
                * 양의 정수의 경우 정렬알고리즘에 의해 위치를 바꾸고,
                * 0이나 음의 정수인 경우 두 객체의 위치는 바뀌지 않는다.
                * 0이나 음의 정수인 경우 두 객체의 위치는 바뀌지 않는다.
                 */
                //1차조건 : '단어의 길이순'
                //2차조건 : '사전순'

                //[1] 단어의 길이가 같을 경우
                if(o1.length() == o2.length()){
                    return o1.compareTo(o2); //사전순 정렬
                }
                //[2] 그 외의 경우
                else{
                    return o1.length() - o2.length();
                }
            }
        });
        System.out.println(inputs[0]);
        for(int i = 1; i<inputs.length; i++){
            if(!inputs[i].equals(inputs[i-1]))
                System.out.println(inputs[i]);
        }
        return null;
    }
}
