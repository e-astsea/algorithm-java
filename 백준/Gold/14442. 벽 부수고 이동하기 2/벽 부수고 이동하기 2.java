import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j]=Integer.parseInt(String.valueOf(str.charAt(j)));
            }
        }
        checked = new boolean[N][M][K+1];
        bfs(arr,0,0,K);
    }
    static class Pair{
        int x;
        int y;
        int distance;
        int crash;

        public Pair(int x, int y, int distance, int crash) {
            this.x = x;
            this.y = y;
            this.distance = distance;
            this.crash = crash;
        }
    }
    static boolean[][][] checked;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    private static void bfs(int[][] arr, int x, int y, int crash) {
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(x,y,0,0));
        while(!q.isEmpty()){
            Pair poll = q.poll();
            if(poll.x==arr.length-1 && poll.y==arr[0].length-1){
                System.out.println(poll.distance+1);
                return;
            }
            for (int i = 0; i < 4; i++) {
                int nx = poll.x+dx[i];
                int ny = poll.y+dy[i];
                if(nx<0 || nx>=arr.length || ny<0 || ny>=arr[0].length){
                    continue;
                }

//
                if(arr[nx][ny] == 0){
                    if(checked[nx][ny][poll.crash]){
                        continue;
                    }
                    checked[nx][ny][poll.crash] = true;
                    q.add(new Pair(nx,ny, poll.distance+1,poll.crash));
                } else{

                    if(poll.crash+1<=crash){
                        if(checked[nx][ny][poll.crash+1]){
                            continue;
                        }
                        checked[nx][ny][poll.crash+1] = true;

                        q.add(new Pair(nx,ny, poll.distance+1, poll.crash+1));
                    }
                }

            }
        }
        System.out.println("-1");
    }
}
