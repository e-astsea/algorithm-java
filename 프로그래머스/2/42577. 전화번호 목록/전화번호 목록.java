import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        List<String> ls = new ArrayList<>();
        
        for(int i=0; i<phone_book.length; i++){
            ls.add(phone_book[i]);
        }
        
        Collections.sort(ls);
        
        for(int i=0; i<ls.size()-1; i++){
            String first = ls.get(i);
            String second = ls.get(i+1);
            if(second.startsWith(first)){
                answer = false;
            }
        }
        return answer;
    }
}