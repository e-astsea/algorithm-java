import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Pair{
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int[][] distance;
    static int N;
    static int M;
    static int[][] arr;
    static boolean[][] checked;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        distance = new int[N][M];
        checked = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j]==2){
                    bfs(i,j);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(arr[i][j]==1 && distance[i][j]==0){
                    System.out.print("-1 ");
                } else {
                    System.out.print(distance[i][j] + " ");
                }
            }
            System.out.println("");
        }
    }

    private static void bfs(int x, int y) {
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(x,y));
        checked[x][y]=true;
        while(!q.isEmpty()){
            Pair poll = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = poll.x+dx[i];
                int ny = poll.y+dy[i];

                if(nx<0 || nx>=N || ny<0 || ny>=M){
                    continue;
                }
                if(arr[nx][ny] ==0){
                    continue;
                }
                if(checked[nx][ny]){
                    continue;
                }
                checked[nx][ny]=true;
                distance[nx][ny] = distance[poll.x][poll.y]+1;
                q.add(new Pair(nx,ny));
            }
        }
    }
}
