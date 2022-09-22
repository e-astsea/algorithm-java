import java.util.*;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        int num=0;
        int prev = 0;
        int cur = 0;
        int flag=0;
        for(int i=0; i<dartResult.length(); i++){
            if(dartResult.charAt(i)>=48 && dartResult.charAt(i)<=57){
                answer+=prev;
                if(flag>=1){
                    answer-=prev;
                    num *= 10;
                    num += dartResult.charAt(i)-48;
                }
                else{
                    num = dartResult.charAt(i)-48;
                }
                flag++;
            }
            else if(dartResult.charAt(i)=='S'){
                prev=cur;
                cur = num;
                flag=0;
            }
            else if(dartResult.charAt(i)=='D'){
                prev=cur;
                cur =num*num;
                flag=0;
            }
            else if(dartResult.charAt(i)=='T'){
                prev=cur;
                cur =num*num*num;
                flag=0;
            }
            else if(dartResult.charAt(i)=='*'){
                prev*=2;
                cur*=2;
                 flag=0;
            }
            else if(dartResult.charAt(i)=='#'){
                cur*=-1;
                flag=0;
            }
            
            if (i == dartResult.length()-1){
                answer += prev;
                answer += cur;
            }


        }
        return answer;
    }
}