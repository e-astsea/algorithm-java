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
    static char[][] board;
    static boolean[][] visited;
    static int[][] fire;
    static int[][] human;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];
        visited = new boolean[N][M];
        fire = new int[N][M];
        human = new int[N][M];

        for (int i = 0; i < N; i++) {
            final String str = br.readLine();
            for (int j = 0; j < M; j++) {
                fire[i][j]=-1;
                human[i][j]=-1;
                board[i][j] = str.charAt(j);
            }
        }

        Queue<Pair> que = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(board[i][j] == 'F'){
                    que.add(new Pair(i,j));
                    visited[i][j]=true;
                    fire[i][j] = 0;
                }
            }
        }
        bfs(que);

        Queue<Pair> que2 = new LinkedList<>();
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(board[i][j] == 'J'){
                    que2.add(new Pair(i,j));
                    visited[i][j]=true;
                    human[i][j] = 0;
                }
            }
        }
        bfsHuman(que2);
    }

    private static void bfsHuman(final Queue<Pair> que2) {
        while(!que2.isEmpty()){
            final Pair poll = que2.poll();
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + poll.x;
                int ny = dy[i] + poll.y;

                if(nx<0 || ny<0 || nx>=N || ny>=M){
                    System.out.println(human[poll.x][poll.y]+1);
                    return;
                }
                if(visited[nx][ny] || board[nx][ny] == '#' ||  fire[nx][ny] != -1 && fire[nx][ny] <= human[poll.x][poll.y] +1){
                    continue;
                }
                que2.add(new Pair(nx,ny));
                human[nx][ny] = human[poll.x][poll.y] + 1;
                visited[nx][ny] = true;
            }
        }
        System.out.println("IMPOSSIBLE");
    }

    private static void bfs(final Queue<Pair> que) {
        while(!que.isEmpty()){
            final Pair poll = que.poll();
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + poll.x;
                int ny = dy[i] + poll.y;

                if(nx<0 || ny<0 || nx>=N || ny>=M){
                    continue;
                }
                if(visited[nx][ny] || board[nx][ny] == '#'){
                    continue;
                }
                que.add(new Pair(nx,ny));
                fire[nx][ny] = fire[poll.x][poll.y] + 1;
                visited[nx][ny] = true;
            }
        }
    }
}
