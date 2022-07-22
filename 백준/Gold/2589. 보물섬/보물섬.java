import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class pair{
    int x;
    int y;
    pair(int x, int y){
        this.x = x;
        this.y =y;
    }
}

public class Main {
    static int M;
    static int N;
    static int[][]arr;
    static int[][]arr2;
    static int[][]checked;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static Queue<pair> que = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N+1][M+1];


        for (int i = 0; i < N; i++) {
            str = br.readLine();
            for (int j = 0; j < M; j++) {
                if(str.charAt(j)=='L') {
                    arr[i][j] = 1;
                }
                else if(str.charAt(j)=='W') {
                    arr[i][j] = 0;
                }
            }
        }



        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j]!=0) {
                    que.add(new pair(i, j));
                    bfs(i,j);
                }
            }
        }

        System.out.println(max-1);
    }

    static int max = 0;

    static void bfs(int x, int y){
        int[][] arr2 = new int[N+1][M+1];
        for(int i = 0 ; i< N ; i++) {
            for(int j=0 ; j < M ; j++) {
                arr2[i][j] = arr[i][j];
            }
        }
        checked=new int[N+1][M+1];
        for(int i = 0 ; i< N ; i++) {
            for(int j=0 ; j < M ; j++) {
                checked[i][j]=0;
            }
        }
        checked[x][y]=1;
        while(!que.isEmpty()){
            pair tmp = que.remove();
            checked[tmp.x][tmp.y]=1;
            for(int i=0; i<4; i++){
                int nx = tmp.x+dx[i];
                int ny = tmp.y+dy[i];

                if(nx>=0 && ny>=0 && nx<N && ny<M){
                    if(arr2[nx][ny]==1 && checked[nx][ny]!=1){
                        checked[nx][ny]=1;
                        arr2[nx][ny] = arr2[tmp.x][tmp.y]+1;
                        if(arr2[nx][ny]>max){
                            max = arr2[nx][ny];
                        }
                        que.add(new pair(nx,ny));
                    }
                }
            }
        }
    }
}