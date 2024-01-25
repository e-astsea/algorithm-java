import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int[] dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = arr[0];
        int result = dp[0];
        for (int i = 1; i < N; i++) {
            int tmp = 0;
            for (int j = 0; j < i; j++) {
                if(arr[j] < arr[i]){
                    tmp = Math.max(tmp,dp[j]);
                }
            }
            dp[i]=tmp+arr[i];
            result = Math.max(result,dp[i]);
        }

        System.out.println(result);
    }
}
