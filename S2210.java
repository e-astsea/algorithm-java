import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class S2210 {
    static String [][]arr= new String [5][5];
    static int [] dx = {0,1,0,-1};
    static int [] dy = {1,0,-1,0};
    static ArrayList<String> al = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0; i<5; i++) {
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);
            for(int j=0; j<5; j++) {
                arr[i][j] = st.nextToken();
            }
        }
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                dfs(i,j,1,"");
            }
        }
        System.out.println(cnt);
    }
    static int cnt=0;
    static String tmp;
    static void dfs(int x, int y,int depth,String tmp){
        if(depth==7){
            if(!al.contains(tmp)){
                al.add(tmp);
                cnt++;
            }
            return;
        }
        for(int i=0; i<4;i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx>=0 && ny>=0 && nx<5 && ny<5){
                dfs(nx,ny,depth+1,tmp+arr[nx][ny]);
            }
        }
    }
}