import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class S4963 {
    static int [][]arr;
    static int [][]check;
    static int N;
    static int M;
    static int []dx = {-1,0,1,0,-1,1,-1,1};
    static int []dy = {0,1,0,-1,-1,1,1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            if(N==0 && M==0){
                break;
            }
            arr = new int[M][N];
            check = new int[M][N];
            for(int i=0; i<M; i++){
                str = br.readLine();
                st = new StringTokenizer(str);
                for(int j=0; j<N; j++){
                    arr[i][j]=Integer.parseInt(st.nextToken());
                }
            }
            int count=0;
            for(int i=0; i<M; i++){
                for(int j=0; j<N; j++){
                    if(check[i][j]!=1 && arr[i][j]==1){
                        dfs(i,j);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }
    static void dfs(int x, int y){
        check[x][y]=1;

        for(int i=0; i<8; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(nx>=0 && ny>=0 && nx<M && ny<N){
                if(check[nx][ny]!=1 && arr[nx][ny]==1){
                    dfs(nx,ny);
                }
            }
        }
    }

}