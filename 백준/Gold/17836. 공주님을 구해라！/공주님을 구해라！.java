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
        boolean check=false;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,1,-1};
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
         N = Integer.parseInt(st.nextToken());
         M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N+1][M+1];
        distance = new int[N+1][M+1];
        distance2 = new int[N+1][M+1];
        boolean[][][] checked = new boolean[N+1][M+1][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs(new Pair(0,0),arr,checked);

        if((distance[N-1][M-1] >0 && distance[N-1][M-1]<=T) || (distance2[N-1][M-1] >0 && distance2[N-1][M-1]<=T)){
            if(distance2[N-1][M-1]==0){
                System.out.println(distance[N-1][M-1]);
            } else if(distance[N-1][M-1]==0){
                System.out.println(distance2[N-1][M-1]);
            }else {
                System.out.println(Math.min(distance[N - 1][M - 1], distance2[N - 1][M - 1]));
            }
        } else{
            System.out.println("Fail");
        }
    }
    static int[][] distance;
    static int[][] distance2;
    private static void bfs(Pair pair,int[][] arr, boolean[][][] checked) {
        Queue<Pair> q = new ArrayDeque<>();
        q.add(pair);
        checked[pair.x][pair.y][0]=true;
        while(!q.isEmpty()){
            Pair p = q.poll();
            for (int i = 0; i < 4; i++) {
                boolean flag = false;
                int nx = p.x+dx[i];
                int ny = p.y+dy[i];
                if(nx<0 || nx>=N || ny<0 || ny>=M){
                    continue;
                }

                if(p.check){
                    if(!checked[nx][ny][1]){
                        checked[nx][ny][1]=true;
                        final Pair np = new Pair(nx, ny);
                        np.check=true;
                        q.add(np);
                    }
                } else{
                    if(arr[nx][ny]==1){
                        continue;
                    }
                    if(checked[nx][ny][0]){
                        continue;
                    }
                    if(arr[nx][ny]==2){
                        flag=true;
                        distance2[nx][ny] = distance[p.x][p.y] + 1;
                    }
                    checked[nx][ny][0]=true;
                    Pair np = new Pair(nx, ny);
                    if(flag)
                        np.check=true;
                    q.add(np);
                }

                if(!p.check) {
                    distance[nx][ny] = distance[p.x][p.y] + 1;

                } else{
                    if(distance2[nx][ny]!=0){

                        distance2[nx][ny] = Math.min(distance2[nx][ny],distance2[p.x][p.y] + 1);
                    }else {
                        distance2[nx][ny] = distance2[p.x][p.y] + 1;
                    }
                }
            }
        }
    }
}
