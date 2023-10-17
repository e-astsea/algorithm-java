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

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int N;
    static int M;

    static int[][] board;
    static int[][] tmp;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        visited = new boolean[N][M];
        Queue<Pair> que = new LinkedList<>();
        tmp = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                visited[i][j] = false;
                board[i][j] = Integer.parseInt(st.nextToken());

                if(board[i][j] == 1){
                    que.add(new Pair(i,j));
                    visited[i][j] = true;
                    tmp[i][j]=0;
                }
            }
        }

        bfs(que);

        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(!visited[i][j] && board[i][j] == 0){
                    System.out.println("-1");
                    return;
                }
                max = Math.max(max,tmp[i][j]);
            }
        }
        System.out.println(max);
    }

    private static void bfs(final Queue<Pair> que) {
        while(!que.isEmpty()){
            final Pair poll = que.poll();
            for (int i = 0; i < 4; i++) {
                int nx = dx[i]+poll.x;
                int ny = dy[i]+poll.y;
                if(nx<0 || ny<0 || nx>=N || ny>=M){
                    continue;
                }
                if(board[nx][ny] == -1 || visited[nx][ny]){
                    continue;
                }
                visited[nx][ny]=true;
                tmp[nx][ny] = tmp[poll.x][poll.y]+1;
                que.add(new Pair(nx,ny));
            }
        }
    }
}
