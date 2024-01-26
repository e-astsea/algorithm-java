import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Integer> ls = new ArrayList<>();
        ls.add(0);

        for (int i = 0; i < N; i++) {
            ls.add(Integer.parseInt(br.readLine()));
        }

        int[] dp = new int[10001];
        dp[0] = 0;
        dp[1] = ls.get(1);
        int maxResult = dp[1];
        for (int i = 2; i < ls.size(); i++) {
            dp[i] = Math.max(dp[i-1],Math.max(dp[Math.max(i-3,0)]+ls.get(i-1)+ls.get(i),dp[i-2]+ls.get(i)));

            maxResult = Math.max(maxResult,dp[i]);
        }

        System.out.println(maxResult);
    }
}
