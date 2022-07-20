import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
// 두개가 한번에 안작동하는 현상, 1이 두개이상일경우..
// 시작 지점 여러개 어케하나 ?
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
    static int[][]checked;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static Queue<pair> que = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
         M = Integer.parseInt(st.nextToken());
         N = Integer.parseInt(st.nextToken());

        arr = new int[N+1][M+1];
        checked =  new int[N+1][M+1];
        for(int i=0; i<N; i++){
            str = br.readLine();
            st = new StringTokenizer(str);
            for(int j=0; j<M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(arr[i][j]==1)
                    que.add(new pair(i,j));
            }
        }
        bfs();

        int check = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(arr[i][j]==0){
                    check=1;
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
            checked[tmp.x][tmp.y]=1;
            for(int i=0; i<4; i++){
                int nx = tmp.x+dx[i];
                int ny = tmp.y+dy[i];

                if(nx>=0 && ny>=0 && nx<N && ny<M){
                    if(arr[nx][ny]==0 && checked[nx][ny]!=1){
                        checked[nx][ny]=1;
                        arr[nx][ny] = arr[tmp.x][tmp.y]+1;
                        if(arr[nx][ny]>max){
                            max = arr[nx][ny];
                        }
                        que.add(new pair(nx,ny));
                    }
                }
            }
        }
    }
}