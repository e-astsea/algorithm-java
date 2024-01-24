import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] dp = new int[1001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        //상근 1 창영 2
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 1;
        for (int i = 3; i < N; i++) {
            if(dp[i-3] == dp[i-1] && dp[i-3] == 1){
                dp[i] = 2;
            } else if(dp[i-3] == dp[i-1] && dp[i-3] == 2){
                dp[i] = 1;
            }
        }
        System.out.println(dp[N-1] == 1 ? "SK" : "CY");
    }
}
