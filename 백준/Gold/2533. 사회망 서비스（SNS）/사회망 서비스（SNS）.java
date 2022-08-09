import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static ArrayList<Integer>[] arr ;
    static Queue<Integer> que = new LinkedList<>();
    static int [][]dp;
    static int []check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        N = Integer.parseInt(str);
        dp = new int[N+1][2];
        arr = new ArrayList[N+1];
        check =new int[N+1];
        for(int i=0; i<=N; i++){
            arr[i]=new ArrayList<Integer>();
        }

        for(int i=0; i<N-1; i++){
            str =br.readLine();
            StringTokenizer st = new StringTokenizer(str);
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            arr[u].add(v);
            arr[v].add(u);
        }



        dfs(1,-1);

            System.out.println(Math.min(dp[1][0],dp[1][1]));
    }



    public static void dfs(int tmp,int parent) {

        if(arr[tmp].size()==0){
            return;
        }
        dp[tmp][0]=0;
        dp[tmp][1]=1;



        for (int j = 0; j < arr[tmp].size(); j++) {
            if(arr[tmp].get(j)!=parent) {
                dfs(arr[tmp].get(j), tmp);
                dp[tmp][0] += dp[arr[tmp].get(j)][1];
                dp[tmp][1] += Math.min(dp[arr[tmp].get(j)][0], dp[arr[tmp].get(j)][1]);
            }
        }

    }
}