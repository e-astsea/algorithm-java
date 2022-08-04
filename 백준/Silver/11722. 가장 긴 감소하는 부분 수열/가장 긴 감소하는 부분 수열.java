import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    static int [][][]checked = new int[61][61][61];
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int T = Integer.parseInt(str);
        int []arr = new int[T];
        int []dp = new int[T];
        str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        for(int i=0; i<T; i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        dp[0]=1;
        for(int i=0; i<T; i++){
            dp[i]=1;
            for(int j=0; j<i; j++){
                if(arr[j]>arr[i] && dp[i]<=dp[j]){
                    dp[i]=dp[j]+1;
                }
            }
        }

        Arrays.sort(dp);
        System.out.println(dp[T-1]);
    }
}