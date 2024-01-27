import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Integer> ls = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            ls.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(ls);
        int[] dp = new int[10001];
        dp[0]=1;
        for (int i = 0; i < ls.size(); i++) {
            int num = ls.get(i);

            for (int j = 0; j <= K; j++) {
                    if(j-num>=0){
                        dp[j] = dp[j-num] + dp[j];
                    }
            }
        }
        System.out.println(dp[K]);
    }
}
