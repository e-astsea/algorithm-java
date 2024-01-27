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

        for (int i = 0; i < ls.size(); i++) {
            int num = ls.get(i);

            for (int j = 1; j <= K; j++) {
                if(j%num == 0){
                   dp[j]=j/num;
                } else{
                    if(j-num>=0){
                        if(dp[j-num]!=0){
                            if(dp[j]==0){
                                dp[j] = dp[j-num]+1;
                            } else {
                                dp[j] = Math.min(dp[j], dp[j - num] + 1);
                            }
                        }
                    }
                }
            }
        }
        System.out.println(dp[K] == 0 ? -1:dp[K]);
    }
}
