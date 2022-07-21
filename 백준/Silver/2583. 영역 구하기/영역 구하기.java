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
    static int[][]arr;
    static int[][]checked;
    static int[] dx = {-1,0,1,0};
    static int[] dy ={0,-1,0,1};
    static int M;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        arr = new int[M+1][N+1];
        checked = new int[M+1][N+1];
        for (int i = 0; i < K; i++) {
            str = br.readLine();
            st = new StringTokenizer(str);
            pair first = new pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            pair second = new pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            for(int a=first.x; a<second.x; a++){
                for(int b = first.y; b<second.y;b++){
                    arr[b][a]=1;
                }
            }
        }

        int count=0;
        ArrayList<Integer> al = new ArrayList<>();
        for(int i=M-1; i>=0; i--){
            for(int j=0; j<N; j++){
                if(arr[i][j]!=1 && checked[i][j]!=1) {
                    cnt=1;
                    count++;
                    bfs(i, j);
                    al.add(cnt);
                }
            }
        }
        Collections.sort(al);
        System.out.println(count);
        for(int i=0; i<count; i++)
            System.out.print(al.get(i)+" ");
    }
    static int cnt=1;
    static void bfs(int x, int y){
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(x,y));
        checked[x][y]=1;
        while(!q.isEmpty()){
            pair p = q.remove();
            for(int i=0; i<4; i++){
                int nx = p.x+dx[i];
                int ny = p.y+dy[i];
                if(nx>=0 && ny>=0 && nx<M && ny<N){
                    if(checked[nx][ny]!=1 && arr[nx][ny]!=1){
                        checked[nx][ny]=1;
                        cnt++;
                        q.add(new pair(nx,ny));
                    }
                }
            }
        }
    }
}