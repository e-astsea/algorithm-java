import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] dp = new int[30][30];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());


            System.out.println(recursion(second,first));
        }
    }

    private static int recursion(int first, int second) {
        if(dp[first][second]!=0){
            return dp[first][second];
        }
        if(first==second || second == 0){
            return dp[first][second]=1;
        }
        return dp[first][second]=recursion(first-1,second) + recursion(first-1, second-1);
    }
}
