import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class pair{
    int x;
    int y;
    int z;
    pair(int x, int y, int z){
        this.x = x;
        this.y =y;
        this.z =z;
    }
}

public class Main {
    static int M;
    static int H;
    static int N;
    static int[][][]arr;
    static int[][][]checked;
    static int[] dx = {-1,0,1,0,0,0};
    static int[] dy = {0,1,0,-1,0,0};
    static int[] dz ={0,0,0,0,-1,1};
    static Queue<pair> que = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        arr = new int[H+1][N+1][M+1];
        checked =  new int[H+1][N+1][M+1];
        for(int a=0; a<H; a++) {
            for (int i = 0; i < N; i++) {
                str = br.readLine();
                st = new StringTokenizer(str);
                for (int j = 0; j < M; j++) {
                    arr[a][i][j] = Integer.parseInt(st.nextToken());
                }
            }
        }
        for(int a=0; a<H; a++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (arr[a][i][j] == 1)
                        que.add(new pair(i, j,a));
                }
            }
        }
        bfs();

        int check = 0;
        for(int a=0; a<H; a++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (arr[a][i][j] == 0) {
                        check = 1;
                    }
                }
            }
        }

        if(check==0 && max!=0)
            System.out.println(max-1);
        else if(max==0 && check==0){
            System.out.println(max);
        }
        else
            System.out.println("-1");
    }
    static int max = 0;

    static void bfs(){
        while(!que.isEmpty()){
            pair tmp = que.remove();
            checked[tmp.z][tmp.x][tmp.y]=1;
            for(int i=0; i<6; i++){
                int nx = tmp.x+dx[i];
                int ny = tmp.y+dy[i];
                int nz = tmp.z+dz[i];

                if(nx>=0 && ny>=0&& nz>=0 && nx<N && ny<M&&nz<H){
                    if(arr[nz][nx][ny]==0 && checked[nz][nx][ny]!=1){
                        checked[nz][nx][ny]=1;
                        arr[nz][nx][ny] = arr[tmp.z][tmp.x][tmp.y]+1;
                        if(arr[nz][nx][ny]>max){
                            max = arr[nz][nx][ny];
                        }
                        que.add(new pair(nx,ny,nz));
                    }
                }
            }
        }
    }
}