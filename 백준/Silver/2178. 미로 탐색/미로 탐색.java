import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class pair {
    int x;
    int y;
    pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static int N;
    static int M;
    static int[][] arr;
    static int[][] visit;
    static int[] dx ={0,-1,0,1};
    static int[] dy ={-1,0,1,0};
    static Queue<pair> que = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visit = new int[N][M];
        for (int i = 0; i < N; i++) {
            str = br.readLine();
            for(int j=0; j<M; j++) {
                arr[i][j]=str.charAt(j)-'0';
            }
        }
        bfs(0,0);

        System.out.println(arr[N-1][M-1]);
        }
    static void bfs(int x, int y){
        visit[x][y]=1;
        que.add(new pair(0,0));
        while(!que.isEmpty()) {
            pair point = que.remove();
            for (int i = 0; i <4; i++) {
                int nx = point.x+dx[i];
                int ny = point.y+dy[i];
                if(nx>=0 && ny>=0 && nx<N && ny<M){
                    if(arr[nx][ny]==1 && visit[nx][ny]!=1){
                        visit[nx][ny]=1;
                        arr[nx][ny]=arr[point.x][point.y]+1;
                        que.add(new pair(nx,ny));
                    }
                }

            }
        }
    }

}