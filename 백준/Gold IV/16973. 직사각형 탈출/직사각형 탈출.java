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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N+1][M+1];
        int[][] road = new int[N+1][M+1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int startX = Integer.parseInt(st.nextToken());
        int startY = Integer.parseInt(st.nextToken());
        int endX = Integer.parseInt(st.nextToken());
        int endY = Integer.parseInt(st.nextToken());

        for (int i = 1; i <=N-H+1 ; i++) {
            for (int j = 1; j <=M-W+1 ; j++) {
                if (check(arr,i,j,H,W)){
                    road[i][j] = 1;
                }
            }
        }

        bfs(road,new Pair(startX,startY));
        System.out.println(checked[endX][endY]);
    }
    static int[][]checked;
    private static void bfs(int[][] road, Pair start) {
        Queue<Pair> q = new ArrayDeque<>();
        q.add(start);
        checked = new int[road.length][road[0].length];
        for (int i = 0; i < road.length; i++) {
            for (int j = 0; j < road[0].length; j++) {
                checked[i][j] = -1;
            }
        }
        checked[start.x][start.y]=0;
        while(!q.isEmpty()){
            Pair poll = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = poll.x+dx[i];
                int ny = poll.y+dy[i];
                if(nx<0 || nx>=road.length || ny<0 || ny>=road[0].length){
                    continue;
                }
                if(road[nx][ny]==0){
                    continue;
                }
                if(checked[nx][ny]!=-1){
                    continue;
                }
                checked[nx][ny]=checked[poll.x][poll.y]+1;
                q.add(new Pair(nx,ny));
            }
        }
    }

    private static boolean check(int[][] arr, int i, int j, int H, int W) {
        for (int a = i; a < i+H; a++) {
            for (int b = j; b < j+W; b++) {
                if(arr[a][b]==1){
                    return false;
                }
            }
        }
        return true;
    }
    /*
    0 1 1 0
    0 1 1 0
    0 0 0 0

    0 1 1 1 0
    0 1 1 1 0
    0 0 0 0 1
    1 1 1 0 1
    1 1 1 0 0

     */
}
