class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        
        for(long i=1; i<=r2; i++){
            int min = (int)Math.ceil((double)Math.sqrt((double)r1*r1-i*i));
            if(min==0){
                min=1;
            }
            
            int max = (int)Math.floor((double)Math.sqrt((double)r2*r2-i*i));
            answer += max-min+1;
        }
        answer *= 4;
        answer += (r2-r1+1) * 4;
        return answer;
    }
}

// (x)^2 + (y)^2 = r^2
 