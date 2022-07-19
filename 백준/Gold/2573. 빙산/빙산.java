import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[][]arr = new int[301][301];
    static int[][]checked = new int[301][301];
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str= br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int flag=0;
        for(int i=0; i<N; i++){
            str = br.readLine();
            st = new StringTokenizer(str);
            for(int j=0; j<M; j++){
                arr[i][j]=Integer.parseInt(st.nextToken());

            }
        }

        int a=0;
        while(true){
            int k=0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(arr[i][j]==0 && k==0){
                        k=0;
                    }
                    else if(arr[i][j]!=0) {
                        k = 1;
                    }
                }
            }
            if(k==0){
                System.out.println("0");
                return;
            }

            int cnt = 0;
            checked = new int[301][301];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (arr[i][j] != 0 && checked[i][j] != 1) {
                        cnt++;
                        dfs(i, j);
                    }
                }
            }
            if(cnt>=2){
                System.out.println(a);
                flag=1;
                break;
            }

            checked = new int[301][301];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (arr[i][j] != 0 && checked[i][j] != 1) {
                        checked[i][j] = 1;
                        dfs_year(i, j);
                    }
                }
            }
            a++;
        }
        if(flag!=1){
            System.out.println("0");
        }

    }
    static void dfs_year(int x, int y){
        for(int i=0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx>=0 && ny>=0 && nx<N && ny<M){
                if(arr[nx][ny]==0 && checked[nx][ny]!=1){
                    if(arr[x][y]>0)
                    arr[x][y]--;
                }
            }
        }
    }
    static void dfs(int x, int y){
        checked[x][y]=1;
        for(int i=0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx>=0 && ny>=0 && nx<N && ny<M){
                if(arr[nx][ny]!=0 && checked[nx][ny]!=1){
                    dfs(nx,ny);
                }
            }
        }
    }
}