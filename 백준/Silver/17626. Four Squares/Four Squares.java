import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] dp = new int[50001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        dp[1]= 1;
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 4; i <= N; i++) {

            int min = Integer.MAX_VALUE;
            for (int j = 2; j*j <= i; j++) {
                min = Math.min(min, dp[i-j*j]);
            }

            dp[i]=min+1;
        }
        System.out.println(dp[N]);
    }
}
