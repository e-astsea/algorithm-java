import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class S2667 {
    static int [][]arr=new int[26][26];
    static int [][]visited=new int[26][26];
    static int []dx={0,1,0,-1};
    static int []dy={1,0,-1,0};
    static int N;
    static int count=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        N = Integer.parseInt(str);

        for(int i=0; i<N; i++){
            str = br.readLine();
            for(int j=0; j<N; j++){
                arr[i][j]=str.charAt(j)-'0';
            }
        }
        ArrayList<Integer> al = new ArrayList<>();
        int cnt=0;
        for(int j=0; j<N; j++){
            for(int k=0; k<N;k++){
                if(visited[j][k]!=1 && arr[j][k]==1){
                    count=1;
                    dfs(j,k);
                    cnt++;
                    al.add(count);
                }
            }
        }
        System.out.println(cnt);
        Collections.sort(al);
        for(int i=0; i<al.size();i++){
            System.out.println(al.get(i));
        }

    }
    static void dfs(int x, int y){
        visited[x][y]=1;
        for(int i=0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx>=0 && ny>=0 && nx<N && ny<N){
                if(arr[nx][ny]==1 && visited[nx][ny]!=1){
                    dfs(nx,ny);
                    count++;
                }
            }
        }
    }
}