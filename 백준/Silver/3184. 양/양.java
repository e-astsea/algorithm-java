import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static String[] map;
    static boolean[][] checked;
    static int sheepNum = 0;
    static int wolfNum = 0;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int R, C;
    static int aliveWolf, aliveSheep;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new String[R];
        checked = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            map[i] = br.readLine();
        }
        aliveSheep = aliveWolf = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (!checked[i][j]) {
                    sheepNum = wolfNum = 0;
                    dfs(i, j);
                    if (sheepNum > wolfNum) {
                        wolfNum = 0;
                    } else {
                        sheepNum = 0;
                    }
                    aliveSheep += sheepNum;
                    aliveWolf += wolfNum;
                }
            }
        }

        System.out.println(aliveSheep + " " + aliveWolf);
    }

    private static void dfs(final int i, final int j) {
        checked[i][j] = true;
        if (map[i].charAt(j) == 'v')
            wolfNum++;
        if (map[i].charAt(j) == 'o')
            sheepNum++;

        for (int k = 0; k < 4; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];

            if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
            if (checked[nx][ny]) continue;
            if (map[nx].charAt(ny) == '#') continue;

            dfs(nx, ny);
        }
    }
}
