import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int N = Integer.parseInt(str);
        int [][]arr = new int[N][3];
        int [][]dp = new int[N][3];
        for(int i=0; i<N; i++) {
            str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }

        int result=0;
        dp[0][0]=arr[0][0];
        dp[0][1]=arr[0][1];
        dp[0][2]=arr[0][2];

        for(int i=1; i<N; i++){
            int e_first = Math.min(dp[i-1][1],dp[i-1][2]);
            int e_second = Math.min(dp[i-1][0], dp[i-1][2]);
            int e_third = Math.min(dp[i-1][0], dp[i-1][1]);

            dp[i][0]= arr[i][0]+e_first;
            dp[i][1]= arr[i][1]+e_second;
            dp[i][2]= arr[i][2]+e_third;
        }
        Arrays.sort(dp[N-1]);

        System.out.println(dp[N-1][0]);





    }
}