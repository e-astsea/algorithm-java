import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S1012 {
    static int[][] arr;
    static int [][] visited;
    static int[] dx={0,1,0,-1};
    static int[] dy={-1,0,1,0};
    static int M;
    static int N;
    static int K;
    static int cnt=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int T = Integer.parseInt(str);


        for(int i=0; i<T; i++){
            str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            arr = new int[51][51];
            visited=new int[51][51];
            for(int j=0; j<K; j++){
                str=br.readLine();
                st = new StringTokenizer(str);
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                arr[x][y]=1;
            }
            for(int a=0; a<M;a++){
                for(int b=0; b<N;b++){
                    if(arr[a][b] == 1 && visited[a][b]!=1) {
                        dfs(a, b);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
            cnt=0;
        }
    }
    static void dfs(int a,int b){
        visited[a][b]=1;
        for(int i=0;i<4;i++){
            int nx = a+dx[i];
            int ny = b+dy[i];

            if(nx>=0 && ny>=0 && nx<M && ny<K) {
                if(arr[nx][ny]==1 && visited[nx][ny]!=1){
                    dfs(nx,ny);
                }
            }

        }
    }
}