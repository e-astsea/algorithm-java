import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Deque<Character> stac = new ArrayDeque<>();

        for(int i=0; i<s.length(); i++){
            Character ch = s.charAt(i);
            if(ch=='('){
                stac.push(ch);
            } else if(ch==')'){
                if(stac.size()==0 || stac.peek() != '(' ){
                    answer = false;
                    break;
                } else{
                    stac.pop();
                }   
            }
        }
        
        if(stac.size()!=0){
            answer =false;
        }

        return answer;
    }
}