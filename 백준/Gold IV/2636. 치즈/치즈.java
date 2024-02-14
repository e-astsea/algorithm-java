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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N+1][M+1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j]==1){
                    cheese++;
                }
            }
        }
        int tmpCheese = 0;
        int count =0;
        while(cheese>0){
            tmpCheese=cheese;
            count++;
            checked = new boolean[N+1][M+1];
            bfs();
        }
        System.out.println(count);
        System.out.println(tmpCheese);
    }
    static int N;
    static int M;
    static int cheese;
    static boolean[][] checked;
    static int[][] arr;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    private static void bfs() {
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(0,0));
        checked[0][0]=true;

        while(!q.isEmpty()){
            Pair pair = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = pair.x+dx[i];
                int ny = pair.y+dy[i];

                if(nx<0 || nx>=N || ny<0 || ny>=M){
                    continue;
                }
                if(checked[nx][ny]){
                    continue;
                }
                if(arr[pair.x][pair.y]==0 && arr[nx][ny]==1){
                    arr[nx][ny]=0;
                    cheese--;
                } else{
                    q.add(new Pair(nx,ny));
                }

                checked[nx][ny]=true;
            }
        }
    }
}
