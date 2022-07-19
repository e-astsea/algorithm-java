import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int [][]arr = new int[101][101];
    static int []dx = {-1,0,1,0};
    static int []dy = {0,1,0,-1};
    static int [][]checked = new int[101][101];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        N = Integer.parseInt(str);

        for(int i=0; i<N; i++){
            str = br.readLine();
            for(int j=0; j<N; j++){
                if(str.charAt(j)=='R')
                    arr[i][j]=1;
                else if(str.charAt(j)=='G')
                    arr[i][j]=2;
                else if(str.charAt(j)=='B')
                    arr[i][j]=3;
            }
        }
        int cnt=0;
        int colorcnt=0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(checked[i][j]!=1){
                    cnt++;
                    dfs(i,j);
                }
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(arr[i][j]==2){
                    arr[i][j]=1;
                }
            }
        }
        checked = new int[101][101];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(checked[i][j]!=1){
                    colorcnt++;
                    dfs(i,j);
                }
            }
        }
        System.out.println(cnt+" "+colorcnt);
    }
    static void dfs(int x, int y){
        checked[x][y]=1;
        int re = arr[x][y];
        for(int i=0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx>=0 && ny>=0 && nx<N && ny<N){
                if(checked[nx][ny]!=1 && arr[nx][ny]==re){
                    dfs(nx,ny);
                }
            }
        }
    }
}