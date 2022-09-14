import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        ArrayList<String> al1 = new ArrayList<>();
        ArrayList<String> al2 = new ArrayList<>();
        
        for(int i=0; i<str1.length(); i++){
            if(i+2<=str1.length()){
                    
                String str = str1.substring(i,i+2);
                if(!((str1.charAt(i)>='a' && str1.charAt(i)<='z')||(str1.charAt(i)>='A' && str1.charAt(i)<='Z')))
                    continue;
                if(!((str1.charAt(i+1)>='a' && str1.charAt(i+1)<='z')||(str1.charAt(i+1)>='A' && str1.charAt(i+1)<='Z')))
                    continue;
                al1.add(str.toLowerCase());
                
            }
        }
        for(int i=0; i<str2.length(); i++){
            if(i+2<=str2.length()){
                String str = str2.substring(i,i+2);
                if(!((str2.charAt(i)>='a' && str2.charAt(i)<='z')||(str2.charAt(i)>='A' && str2.charAt(i)<='Z')))
                    continue;
                if(!((str2.charAt(i+1)>='a' && str2.charAt(i+1)<='z')||(str2.charAt(i+1)>='A' && str2.charAt(i+1)<='Z')))
                    continue;
                
                
                al2.add(str.toLowerCase());
            }
        }
        
        boolean[] bl1 = new boolean[al1.size()];
        boolean[] bl2 = new boolean[al2.size()];
        Collections.sort(al1);
        Collections.sort(al2);
        int inter=0;
        
        for(int i=0; i<al1.size(); i++){
            for(int j=0; j<al2.size(); j++){
                if((al1.get(i)).equals(al2.get(j)) && bl1[i]!=true && bl2[j]!=true){
                    bl1[i]=true;
                    bl2[j]=true;
                    inter++;
                    break;
                }
            }
        }
        
        double sum = (double)(al1.size()+al2.size())-(double)inter;
        
        double result;
        
        if(sum==0){
            result=1;
        }
        else
            result = inter/sum;
        
        
        int answer = 0;
        answer = (int)(result*65536);
        
        return answer;
    }
}