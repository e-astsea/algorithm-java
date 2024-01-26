import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static long[][] dp;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dp = new long[N+1][N+1];
        arr = new int[N+1][N+1];

        for (int i = 0; i <N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0]=1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(i==N-1 && j==N-1){
                    System.out.println(dp[N-1][N-1]);
                    return;
                }
                int next = arr[i][j];
                if(dp[i][j]==0){
                    continue;
                }
                if(i+next<=N){
                    dp[i+next][j] += dp[i][j];
                }
                if(j+next<=N){
                    dp[i][j+next] += dp[i][j];
                }
            }
        }
//        recursion(0,0);
    }

//    private static void recursion(int x, int y) {
//
//        if(x>=N || y>=N){
//            return;
//        }
//
//        if(x==N-1 && y==N-1){
//            dp[x][y]+=1;
//            return;
//        }
//        int move = arr[x][y];
//
//        dp[x][y]+=1;
//        recursion(x+move,y);
//        recursion(x,y+move);
//    }
}
