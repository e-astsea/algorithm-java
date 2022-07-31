import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int N = Integer.parseInt(str);

        long [][]arr = new long[N+1][2];
        arr[0][0]=0;
        arr[0][1]=1;
        for(int i=1; i<=N; i++){
            arr[i][0]=arr[i-1][1]+arr[i-1][0];
            arr[i][1]=arr[i-1][0];
        }

        System.out.println(arr[N-1][0]+arr[N-1][1]);
    }
}