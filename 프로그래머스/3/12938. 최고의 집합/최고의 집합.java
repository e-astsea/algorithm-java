import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        
        int divide = s/n;
        
        for(int i=0; i<s%n;i++){
            answer[i] = divide+1;
        }
        
        for(int i=s%n; i<n;i++){
            answer[i] = divide;
        }
        
        Arrays.sort(answer);
        if(s/n==0){
            answer = new int[1];
            answer[0] = -1;
        }
        return answer;
    }
}


//그래서 (s/n)만큼 배열을 채워주고 (s/n)+1만큼 채워주는게 원소의 곱이 가장 커진다.
// n=3, s=30의 경우 9,10,11보다 10,10,10이 각 원소의 곱이 최대가 된다.
// n=3, s=31의 경우 9,10,12보다 10,10,11이 각 원소의 곱이 최대가 된다.
// n=5, s=73 이런경우에도 14,14,15,15,15 이럴때 곱이 최대가 된다.