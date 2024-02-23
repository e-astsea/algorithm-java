import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr= new int[N+1][N+1];
        dfs(N,0,0);

        StringBuffer sb = new StringBuffer();
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                sb.append(arr[i][j] ==1 ? "*" : " ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
    static int[][] arr;
    private static void dfs(int n,int x, int y) {
        if(n==1){
            arr[x][y]=1;
            return;
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(!(i==1 && j==1)) {
                    dfs(n / 3, x + i * n / 3, y + j * n / 3);
                }
            }
        }
    }
}
