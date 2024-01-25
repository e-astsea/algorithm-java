import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    static BigInteger[][] dp = new BigInteger[1000][1000];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        recursive(N,M);

        System.out.println(dp[N][M]);
    }

    private static BigInteger recursive(int n, int m) {
        if(dp[n][m] !=null){
            return new BigInteger(String.valueOf(dp[n][m]));
        }
        if(n==m || m==0){
            return new BigInteger("1");
        }
        return dp[n][m] = new BigInteger(String.valueOf(recursive(n-1,m))).add(new BigInteger(String.valueOf(recursive(n-1,m-1))));
    }
}
