import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


public class Main {
    static int []dx = {1,-1,0,0};
    static int []dy = {0,0,-1,1};
    static int [][]arr;
    static int [][]checked;
    static double []percent;
    static int N;
    static double result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);


        N = Integer.parseInt(st.nextToken());
        arr = new int[29][29];
        checked = new int[29][29];
        percent = new double[4];
        for(int i=0; i<4; i++){
            percent[i]=Double.parseDouble(st.nextToken())/100;
        }

        dfs(0,14,14,1);
        System.out.println(result);
    }
    static void dfs(int depth,int x,int y, double total){
        if(depth == N){
            result+=total;
            return;
        }
        checked[x][y]=1;
        for(int i=0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(checked[nx][ny]==0){
                if((nx>=0 && ny>=0) && (nx<29 && ny<29)){
                    checked[nx][ny]=1;
                    dfs(depth+1, nx,ny,total*percent[i]);
                    checked[nx][ny]=0;
                }
            }

        }

    }
}