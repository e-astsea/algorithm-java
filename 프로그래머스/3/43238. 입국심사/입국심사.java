import java.util.Arrays;
class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        Arrays.sort(times);
        long start = 0;
        long end = times[times.length-1] * (long)n;
        
        while(start<=end){
            long mid = (start+end)/2;
            long ans = 0;
            for(int i=0; i<times.length; i++){
                ans+=mid/times[i];
            }
            if(ans>=n){
                end = mid-1;
                answer = mid;
            } else{
                start = mid+1;
            }
        }

        return answer;
    }
}