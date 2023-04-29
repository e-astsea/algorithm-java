
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static int[][] arr = new int[101][101];
    static int[][] tmp;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] checked;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String str = br.readLine();
        N = Integer.parseInt(str);

        for (int i = 0; i < N; i++) {
            str = br.readLine();
            st = new StringTokenizer(str);
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = -1;
        int cnt = 0;

        for (int waterHeight = 0; waterHeight < 101; waterHeight++) {
            tmp = new int[101][101];
            checked = new int[101][101];
            cnt = 0;
            checkUnderWater(waterHeight);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (tmp[i][j] == 1 && checked[i][j] != 1) {
                        cnt++;
                        dfs(i, j);
                    }
                }
            }
            if (max <= cnt)
                max = cnt;
        }

        System.out.println(max);
    }

    private static void checkUnderWater(int waterHeight) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] <= waterHeight) {
                    tmp[i][j] = 0;
                } else {
                    tmp[i][j] = 1;
                }
            }
        }
    }

    static void dfs(int x, int y) {
        checked[x][y] = 1;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                if (tmp[nx][ny] == 1 && checked[nx][ny] != 1) {
                    dfs(nx, ny);
                }
            }
        }
    }
}
