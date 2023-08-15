import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[][] ls;
    static int[][] checked;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        ls = new int[N][M];
        checked = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                ls[i][j]=-1;
                checked[i][j]=-1;
            }
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken())-1;
            int second = Integer.parseInt(st.nextToken())-1;

            ls[first][second] = 1;
        }
        int realAnswer =0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(checked[i][j] == -1 && ls[i][j] == 1) {
                    answer = 0;
                    dfs(i, j);
                    realAnswer = Math.max(answer,realAnswer);
                }
            }
        }
        System.out.println(realAnswer);
    }
    static int answer =0;
    private static void dfs(int i, int j) {
        answer++;
        checked[i][j] = 1;
        for (int k = 0; k < 4; k++) {
            int nx = i+dx[k];
            int ny = j+dy[k];
            if(nx<0 || ny<0 || nx>=N || ny>=M){
                continue;
            }
            if(checked[nx][ny]== -1 && ls[nx][ny] ==1)
                dfs(nx,ny);
        }
    }
}
