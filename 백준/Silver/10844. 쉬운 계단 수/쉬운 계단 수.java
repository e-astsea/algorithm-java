import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[][] dp = new long[101][101];

        for (int i = 0; i <= 9; i++) {
            dp[0][i] = 1;
        }


        for (int i = 1; i <= N; i++) {
            for (int j = 0; j<= 9; j++) {
                if(j==0){
                    dp[i][0]=dp[i-1][j+1]% 1000000000;
                } else if(j==9){
                    dp[i][9]=dp[i-1][j-1]% 1000000000;
                } else {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1])% 1000000000;
                }
            }
        }


        long result = 0;
        for (int i = 1; i <=9 ; i++) {
            result += dp[N-1][i];
            result %= 1000000000;
        }
        System.out.println(result);
    }
}
