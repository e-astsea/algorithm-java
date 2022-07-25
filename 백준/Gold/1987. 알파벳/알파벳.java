import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static char [][]arr= new char [20][20];
    static int [][]checked = new int [20][20];
    static int []dx= {-1,0,1,0};
    static int []dy= {0,1,0,-1};
    static int R;
    static int C;
    static ArrayList<Character> al = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        for(int i=0; i<R; i++){
            str = br.readLine();
            for(int j=0; j<C; j++){
                arr[i][j]=str.charAt(j);
            }
        }
        checked[0][0]=1;
        dfs(0,0,1);
        System.out.println(max);

    }
    static int max=0;
    static int cnt=0;
    static void dfs(int x, int y, int d){
        al.add(arr[x][y]);
        checked[x][y]=1;
        if(max<d){
            max=d;
        }
        for(int i=0; i<4; i++){

            int nx = x+dx[i];
            int ny = y+dy[i];
            cnt=0;
            if(nx>=0 && ny>=0 && nx<R && ny<C && checked[nx][ny]!=1){
                for(int j=0; j<al.size();j++){
                    if(arr[nx][ny]==al.get(j)){
                        cnt=1;
                        break;
                    }
                }
                if(cnt==1){
                    continue;
                }
                dfs(nx,ny,d+1);
            }

        }
        al.remove(al.size()-1);
        checked[x][y]=0;

    }
}