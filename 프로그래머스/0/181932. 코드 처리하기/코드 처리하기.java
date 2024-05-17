class Solution {
    public String solution(String code) {
        String answer = "";
        int mode = 0;
        
        for(int i = 0 ; i<code.length() ; i++){
            if(mode == 0){
                if(code.charAt(i)!='1' && i%2==0){
                     answer+= Character.toString(code.charAt(i));
                    
                    
                }
                else if (code.charAt(i)=='1'){
                    mode=1;
                }
             } 
            else if(mode == 1 ){
                if(code.charAt(i) !='1' && i%2 != 0){
                    answer+=Character.toString(code.charAt(i));
                }
                else if(code.charAt(i)=='1'){
                    mode = 0;
                }                
            }
        }
         if(answer.isEmpty()){
                answer="EMPTY";
            }
        return answer;
    }
}