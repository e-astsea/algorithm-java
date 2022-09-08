import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 1000;
        int tmp=0;

        for(int i=1; i<=s.length(); i++){
            tmp=0;
            int count=0;
            String a =s.substring(tmp,tmp+i);
            StringBuffer sb = new StringBuffer();
            int flag=0;
            for(int j=0; j<=s.length(); j+=i){
                    if(j+i<=s.length() && a.equals(s.substring(j,j+i))){
                        //System.out.println(i+" "+j+" "+tmp+" "+a + " "+ s.substring(j,j+i));
                        count++;
                        
                    }
                    else if(j+i<=s.length()){
                        //System.out.println(j+" "+i);
                        if(count!=1)
                            sb.append(count);
                        sb.append(a);
                        a= s.substring(j,j+i);
                        j-=i;
                        count=0;
                    }
                if(j+i>=s.length()){
                            if(count!=1)
                                sb.append(count);
                            sb.append(a);
                            if(s.length()%i!=0)
                                sb.append(s.substring(j,s.length()));
                            flag=1;
                            
                            if(answer>sb.length()){
                                answer=sb.length();
                            }
                        }
                
            }
            
            
        }
        
        
        return answer;
    }
}

