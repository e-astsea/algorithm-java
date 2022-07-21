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
    static int[] dx={-2,-2,-1,-1,1,1,2,2};
    static int[] dy={1,-1,2,-2,2,-2,1,-1};
    static int[][] checked;
    static int[][] arr;
    static int I;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st;
        int T = Integer.parseInt(str);
        for(int i=0; i<T; i++){
            str = br.readLine();
            I = Integer.parseInt(str);
            arr = new int[I+1][I+1];
            checked = new int[I+1][I+1];

            String s = br.readLine();
            st=new StringTokenizer(s);
            int f = Integer.parseInt(st.nextToken());
            int f2 = Integer.parseInt(st.nextToken());

            str = br.readLine();
            st = new StringTokenizer(str);
            int e = Integer.parseInt(st.nextToken());
            int e2 = Integer.parseInt(st.nextToken());
            bfs(f,f2);

            if(arr[e][e2]!=0){
                System.out.println(arr[e][e2]);
            }
            else
                System.out.println("0");
        }

    }
    static void bfs(int x, int y){
        Queue<pair> que = new LinkedList<>();
        que.add(new pair(x,y));

        checked[x][y]=1;
        while(!que.isEmpty()){
            pair p = que.remove();
            for(int i=0; i<8; i++){
                int nx = p.x+dx[i];
                int ny = p.y+dy[i];
                if(nx>=0 && ny>=0 && nx<I && ny<I){
                    if(checked[nx][ny]!=1){
                        checked[nx][ny]=1;
                        arr[nx][ny]=arr[p.x][p.y]+1;
                        que.add(new pair(nx,ny));
                    }
                }
            }
        }
    }
}