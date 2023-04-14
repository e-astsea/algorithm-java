import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int dx[] = {-1,1,0,0};
    public static int dy[] = {0,0,-1,1};
    public static int visit[][];
    public static int map[][];
    public static int N;
    public static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];

        visit = new int[N + 1][M + 1];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                visit[i][j] = -1;
            }
        }
        int result = dfs(0,0);
        System.out.println(result);
    }

    private static int dfs(int x, int y) {
        if(x == N-1 && y == M-1){
            return 1;
        }
        if(visit[x][y] != -1){
            return visit[x][y];
        }

        if(visit[x][y] == -1){
            visit[x][y]=0;

            for(int i=0; i<4; i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(nx >= 0 && ny>=0 && nx<N && ny<M){
                    if(map[x][y]>map[nx][ny]){
                        visit[x][y] += dfs(nx,ny);
                    }
                }
            }
        }
        return visit[x][y];
    }
}
