import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
//문제를 잘못이해함. . .. 처음에는 1번과 n번(어떤아무거나)랑 같은게있으면안된다는줄 근데 그냥 마지막과
//겹치면 안되는거였음
public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int N = Integer.parseInt(str);
        int [][]arr = new int[N][3];
        int [][][]dp = new int[3][N][3];
        for(int i=0; i<N; i++) {
            str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }

        int result=Integer.MAX_VALUE;
        for(int k=0; k<=2; k++) {

            for (int i = 0; i <= 2; i++)
            {
                if (i == k)
                    dp[k][0][i] = arr[0][i];
                else
                    dp[k][0][i] = Integer.MAX_VALUE;
            }

            for (int i = 1; i < N; i++) {
                int e_first = Math.min(dp[k][i - 1][1], dp[k][i - 1][2]);
                int e_second = Math.min(dp[k][i - 1][0], dp[k][i - 1][2]);
                int e_third = Math.min(dp[k][i - 1][0], dp[k][i - 1][1]);

                dp[k][i][0] = arr[i][0] + e_first;
                dp[k][i][1] = arr[i][1] + e_second;
                dp[k][i][2] = arr[i][2] + e_third;

                if(dp[k][i][0]<0){
                    dp[k][i][0]=Integer.MAX_VALUE;
                }
                else if(dp[k][i][1]<0){
                    dp[k][i][1]=Integer.MAX_VALUE;
                }else if(dp[k][i][2]<0){
                    dp[k][i][2]=Integer.MAX_VALUE;
                }
            }

            for(int i=0; i<=2; i++) {
                if (k == i) continue;
                result = Math.min(result, dp[k][N-1][i]);
            }
        }


        System.out.println(result);



    }
}