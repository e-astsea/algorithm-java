import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int [] dx = {0,1,0,-1};
    static int [] dy = {1,0,-1,0};
    static int N;
    static int M;
    static int [][] arr;
    static int [][] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[505][501];
        check = new int[501][501];
        for(int i=0; i<N; i++){
            str=br.readLine();
            st= new StringTokenizer(str);
            for(int j=0; j<M; j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        int num=0;
        for(int i=0; i<N;i++){
            for(int j=0; j<M;j++){
                if(arr[i][j]==1 && check[i][j]!=1){
                    num++;
                    dfs(i,j);
                    cnt=1;
                }
            }
        }
        System.out.println(num +"\n"+max);
    }
    static int max=0;
    static int cnt=1;
    static void dfs(int x, int y){
        if(cnt>max){
            max=cnt;
        }
        check[x][y]=1;
        for(int i=0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(nx>=0 && ny>=0 && nx<N &&ny<M){
                if(check[nx][ny]!=1 && arr[nx][ny]==1){
                    cnt++;
                    dfs(nx,ny);
                }
            }
        }

    }
}