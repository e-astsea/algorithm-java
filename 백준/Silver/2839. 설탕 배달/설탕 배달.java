import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] dp = new int[5001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        dp[3]=1;
        dp[5]=1;

        for (int i = 6; i <= N; i++) {
            int result = Integer.MAX_VALUE;
            if(dp[i-3] != 0){
                result = dp[i-3]+1;
                dp[i] = result;
            }
            if(dp[i-5] != 0){
                result = Math.min(result,dp[i-5]+1);
                dp[i] = result;
            }
        }
        System.out.println(dp[N] == 0 ? -1 : dp[N]);
    }
}
