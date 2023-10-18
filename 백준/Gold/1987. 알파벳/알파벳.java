import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,1,-1};
    static int R;
    static int C;
    static Character[][] arr;
    static boolean[] visited;
    static int count =0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new Character[R][C];
        visited = new boolean[26];
        for (int i = 0; i < R; i++) {
            final String str = br.readLine();
            for (int j = 0; j < C; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        visited[arr[0][0]-65]=true;
        dfs(0,0,1);

        System.out.println(count);
    }

    private static void dfs(final int x, final int y, int depth) {
        count = Math.max(count, depth);
        for (int i = 0; i < 4; i++) {
            int nx = x+ dx[i];
            int ny = y+ dy[i];
            if(nx<0 || ny<0 || nx>=R || ny>=C)
                continue;
            if(visited[arr[nx][ny]-65])
                continue;

            visited[arr[nx][ny]-65]=true;
            dfs(nx,ny, depth+1);
            visited[arr[nx][ny]-65]=false;
        }
    }
}
