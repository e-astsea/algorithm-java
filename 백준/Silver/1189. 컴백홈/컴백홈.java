import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static class Pair{
        int x;
        int y;

        public Pair(final int x, final int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Character[][] arr;
    static int R;
    static int C;
    static int K;
    static boolean[][] visited;
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new Character[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            final String str = br.readLine();
            for (int j = 0; j < C; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        visited[R-1][0]=true;
        dfs(new Pair(R-1,0),1);
        System.out.println(result);
    }

    private static void dfs(final Pair pair, int depth) {
        if(depth==K && pair.x == 0 && pair.y == C-1){
            result++;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = pair.x+dx[i];
            int ny = pair.y+dy[i];
            if(nx<0 || ny<0 || nx>=R||ny>=C){
                continue;
            }
            if(arr[nx][ny] == 'T' || visited[nx][ny]){
                continue;
            }
            visited[nx][ny]=true;
            dfs(new Pair(nx,ny), depth+1);
            visited[nx][ny]=false;

        }
    }
}
