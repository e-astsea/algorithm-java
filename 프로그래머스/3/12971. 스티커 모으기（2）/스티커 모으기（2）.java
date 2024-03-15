class Solution {
    public int solution(int sticker[]) {
        int answer = 0;

        int[] dp = new int[sticker.length];
        
        if(sticker.length==1){
            return sticker[0];
        } else if(sticker.length == 2){
            return Math.max(sticker[0],sticker[1]);
        }
        dp[0] = sticker[0];
        dp[1] = dp[0];
        for(int i=2; i<sticker.length-1; i++){
            dp[i] = Math.max(dp[i-2]+sticker[i],dp[i-1]);
        }
        
        for(int i=0; i<sticker.length; i++){
            answer = Math.max(dp[i],answer);
        }
        
        dp[0] = 0;
        dp[1] = sticker[1];
        for(int i=2; i<sticker.length; i++){
            dp[i] = Math.max(dp[i-2]+sticker[i],dp[i-1]);
        }
        
        for(int i=0; i<sticker.length; i++){
            answer = Math.max(dp[i],answer);
        }
        
        return answer;
    }
}