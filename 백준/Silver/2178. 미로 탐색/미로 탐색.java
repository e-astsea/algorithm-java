import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
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
    static int N;
    static int M;
    static boolean[][] visited;
    static int[][] arr;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N][M];
        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            final String str = br.readLine();
            for (int j = 0; j < M; j++) {
                visited[i][j] = false;
                arr[i][j] = str.charAt(j)-'0';
            }
        }

        final int bfs = bfs(new Pair(0, 0));
        System.out.println(bfs);
    }

    private static int bfs(final Pair pair) {
        Queue<Pair> que = new LinkedList<>();
        que.add(pair);
        visited[pair.x][pair.y] = true;
        int[][] cal = new int[N][M];
        cal[0][0] = 1;
        while(!que.isEmpty()){
            final Pair poll = que.poll();
            for (int i = 0; i < 4; i++) {
                int nx = poll.x + dx[i];
                int ny = poll.y + dy[i];
                if(nx<0 || ny<0 || nx>=N || ny>=M){
                    continue;
                }
                if(visited[nx][ny] || arr[nx][ny] == 0){
                    continue;
                }
                que.add(new Pair(nx,ny));
                cal[nx][ny] = cal[poll.x][poll.y] + 1;
                visited[nx][ny]=true;
            }
        }
        return cal[N-1][M-1];
    }
}
