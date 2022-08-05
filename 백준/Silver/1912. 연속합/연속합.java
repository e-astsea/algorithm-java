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
        dp[0]=arr[0];
        for(int i=1; i<T; i++){
            int max=-100001;
            if(dp[i-1]>0)
            dp[i]+=dp[i-1]+arr[i];
            else{
                dp[i]=arr[i];
            }
        }


        Arrays.sort(dp);
        System.out.println(dp[T-1]);



    }
}