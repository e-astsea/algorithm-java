import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};
    static int W;
    static int H;

    static class pair {
        int x;
        int y;

        public pair(final int x, final int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        final int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            int answer = 0;
            char[][] array = new char[H + 1][W + 1];
            for (int j = 0; j < H; j++) {
                final String str = br.readLine();
                for (int k = 0; k < W; k++) {
                    array[j][k] = str.charAt(k);
                }
            }

            for (int j = 0; j < H; j++) {
                for (int k = 0; k < W; k++) {
                    if (array[j][k] == '.') {
                        continue;
                    }
                    bfs(array, new pair(j, k));
                    answer++;
                }
            }
            System.out.println(answer);
        }
    }

    private static void bfs(final char[][] array, pair pair) {
        Queue<pair> queue = new ArrayDeque<>();
        queue.add(pair);
        array[pair.x][pair.y] = '.';

        while (!queue.isEmpty()) {
            pair num = queue.poll();
            for (int i = 0; i < 4; i++) {
                pair newPair = new pair(num.x + dx[i], num.y + dy[i]);

                if (newPair.x < 0 || newPair.y < 0 || newPair.x > H || newPair.y > W) {
                    continue;
                }
                if (array[newPair.x][newPair.y] == '#') {
                    queue.add(newPair);
                    array[newPair.x][newPair.y] = '.';
                }
            }
        }
    }
}
