import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S2606 {
    static int[][] arr = new int[1001][1001];
    static int [] visited=new int[1001];
    static int cnt=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int N = Integer.parseInt(st.nextToken());
        str = br.readLine();
        int M = Integer.parseInt(str);

        for(int i=0; i<M; i++){
            str= br.readLine();
            st=new StringTokenizer(str);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = 1;
            arr[b][a] = 1;
        }
        dfs(1);
        System.out.println(cnt);
    }
    public static void dfs(int index){
        if(visited[index]==1){
            return;
        }
        else{
            visited[index]=1;

            for(int i=0; i<1001; i++){
                if(arr[index][i]==1 && visited[i]!=1){
                    cnt++;
                    dfs(i);
                }
            }
        }
    }
}