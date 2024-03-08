class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        
        int[][] dp = new int[triangle.length][triangle[triangle.length-1].length];
        
        for(int i=0; i<triangle.length; i++){
            for(int j=0; j<triangle[i].length; j++){
                if(i==0 && j==0){
                    dp[i][j]=triangle[i][j];
                } else if(j==0){
                    dp[i][j]=dp[i-1][j] + triangle[i][j];
                } else if(j==triangle[i].length-1){
                    dp[i][j] = dp[i-1][j-1]+triangle[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j-1],dp[i-1][j])+triangle[i][j];
                }
                answer = Math.max(dp[i][j],answer);
            }
        }
    
        
        return answer;
    }
}