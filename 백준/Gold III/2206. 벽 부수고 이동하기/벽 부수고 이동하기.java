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
        int distance;
        boolean crash = false;

        public Pair(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j]=Integer.parseInt(String.valueOf(str.charAt(j)));
            }
        }

        bfs(arr,N,M);
    }
    static boolean[][] checked;
    static boolean[][] checked2;

    private static void bfs(int[][] arr, int n, int m) {
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(0,0,0));
        checked = new boolean[arr.length][arr[0].length];
        checked2 = new boolean[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                checked[i][j]=false;
                checked2[i][j]=false;
            }
        }
        checked[0][0]=true;
        checked2[0][0]=true;
        while(!q.isEmpty()){
            Pair poll = q.poll();
            if (poll.x == arr.length-1 && poll.y == arr[0].length-1) {
                System.out.println(poll.distance+1);
                return;
            }
            for (int i = 0; i < 4; i++) {
                int nx = poll.x + dx[i];
                int ny = poll.y + dy[i];
                if(nx<0 || nx>=arr.length || ny<0|| ny>=arr[0].length){
                    continue;
                }
                final Pair np = new Pair(nx, ny, poll.distance + 1);
                if(arr[nx][ny]==0){
                    if(!poll.crash){
                        if(checked2[nx][ny]){
                            continue;
                        }
                        q.add(np);

                        checked2[nx][ny]=true;
                    } else{
                        if(checked[nx][ny]){
                            continue;
                        }
                        np.crash=true;
                        q.add(np);
                        checked[nx][ny]=true;
                    }
                } else{
                    if(!poll.crash){
                        checked[nx][ny]=true;
                        np.crash=true;
                        q.add(np);
                    }
                }
            }
        }
        System.out.println("-1");
    }
}
