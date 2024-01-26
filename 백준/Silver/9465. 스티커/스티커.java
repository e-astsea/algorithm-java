import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int a = 0; a < T; a++) {
            int N = Integer.parseInt(br.readLine());

            int[][] dp = new int[2][N+1];
            int[][] arr = new int[2][N+1];
            for (int i = 0; i < 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dp[0][0] = arr[0][0];
            dp[1][0] = arr[1][0];

            int maxResult = Math.max(dp[0][0],dp[1][0]);
            for (int i = 1; i < N; i++) {
                int max = Math.max(dp[0][i - 1], dp[1][i - 1]);
                if (dp[0][i - 1] == max) {
                    dp[0][i] = Math.max(dp[1][i-1] + arr[0][i], max);
                    dp[1][i] = max + arr[1][i];
                } else if (dp[1][i - 1] == max) {
                    dp[0][i] = max + arr[0][i];
                    dp[1][i] = Math.max(dp[0][i-1] + arr[1][i], max);
                }
                maxResult = Math.max(maxResult, Math.max(dp[0][i], dp[1][i]));
            }
            System.out.println(maxResult);
        }
    }
}
