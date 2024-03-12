class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] dp = new int[n+1][m+1];
        
        if(puddles[0].length==2)
        for(int i=0; i<puddles.length; i++){
            dp[puddles[i][1]][puddles[i][0]] = -1;
        }
        
        for(int i=1; i<=n; i++){
            if(dp[i][1]==-1){
                break;
            }
            dp[i][1]=1;
        }
        for(int j=1; j<=m; j++){
            if(dp[1][j]==-1){
                break;
            }
            dp[1][j]=1;
        }
        

        
        for(int i = 2; i<=n; i++){
            for(int j =2; j<=m; j++){
                if(dp[i][j]==-1){
                    continue;
                }
                if(dp[i][j-1]==-1){
                    dp[i][j] = dp[i-1][j] %1000000007;
                } else if(dp[i-1][j]==-1){
                    dp[i][j] = dp[i][j-1] % 1000000007;
                } else{
                    dp[i][j] = (dp[i][j-1]+dp[i-1][j]) % 1000000007;
                }
            }
        }

        if(dp[n][m]==-1){
            dp[n][m]=0;
        }
        return dp[n][m]%1000000007;
    }
}