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

        public Pair(final int x, final int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[] dx = {-1,0,0,1};
    static int[] dy = {0,1,-1,0};
    static int N;
    static int M;
    static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new char[N][M];
        Pair start = null;
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                if(str.charAt(j) == 'I'){
                   start = new Pair(i,j);
                }
                arr[i][j] = str.charAt(j);
            }
        }

        final int answer = bfs(start);

        System.out.println(answer == 0 ? "TT" : answer);
    }

    private static int bfs(final Pair start) {
        Queue<Pair> q = new ArrayDeque<>();
        q.add(start);
        arr[start.x][start.y] = ' ';
        int answer =  0;
        while(!q.isEmpty()){
            final Pair now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if(nx<0 || ny<0 || nx>=N || ny>=M){
                    continue;
                }
                if(arr[nx][ny] =='P') {
                    arr[nx][ny] = ' ';
                    answer++;
                    q.add(new Pair(nx, ny));
                }
                if(arr[nx][ny] =='O') {
                    arr[nx][ny] = ' ';
                    q.add(new Pair(nx, ny));
                }
            }
        }
        return answer;
    }
}
