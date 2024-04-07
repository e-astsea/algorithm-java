import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][2];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0]=Integer.parseInt(st.nextToken());
            arr[i][1]=Integer.parseInt(st.nextToken());
        }

        int[] result = new int[N+1];
        for (int i = 0; i < N; i++) {
            int nowMax = arr[i][1] + result[i];
            int nextIndex = i+arr[i][0];
            if(nextIndex<=N){
                result[nextIndex] = Math.max(result[nextIndex],nowMax);
                for (int j = nextIndex; j < N; j++) {
                    result[j] = Math.max(result[nextIndex],result[j]);
                }
            }
        }
//        for (int i = 0; i <=N; i++) {
//            System.out.println(result[i]);
//        }

        int maxAnswer = 0;
        for (int i = 0; i <= N; i++) {
            maxAnswer = Math.max(maxAnswer,result[i]);
        }
        System.out.println(maxAnswer);


    }
    /*
    dp[1] =
    dp[2] =
    dp[3] =
    dp[4] =
    dp[5] = 50
    dp[6] = 50
    dp[7] = 50
    dp[8] = 50
    dp[9] = 50
    dp[10] = 50

     */
}
