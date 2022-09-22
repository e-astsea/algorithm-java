import java.util.*;
import java.io.*;

class Solution {
    public String solution(int n, int t, int m, int p) throws IOException {
        ArrayList<Character> al = new ArrayList<>();
        String answer = "";
        int i=0;
        int k=0;
        int size=0;
        while(true){
            String str = Integer.toString(i,n).toUpperCase();
            
            for(int j=0; j<str.length(); j++){
                //System.out.println(str.charAt(j));
                if((k%m)==(p-1)){
                    al.add(str.charAt(j));
                    size++;
                    if(size==t)
                    break;
                }
                k++;
            }    
            i++;
            if(size==t)
                    break;
        }
        for(int z=0; z<al.size(); z++)
            answer += al.get(z);
        return answer;
    }
    
}
