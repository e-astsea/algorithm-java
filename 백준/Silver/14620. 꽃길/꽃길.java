import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N+1][N+1];
        boolean[][] checked = new boolean[N+1][N+1];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cal(arr, checked, 0, 0);
        System.out.println(result);
    }
    static int result = Integer.MAX_VALUE;
    private static void cal(int[][] arr, boolean[][] checked, int depth, int cost) {
        if(depth == 3){
            result = Math.min(result,cost);
            return;
        }

        for (int i = 1; i < N - 1; i++) {
            for (int j = 1; j < N - 1; j++) {
                if(checked[i][j] || checked[i-1][j] || checked[i+1][j] || checked[i][j-1] || checked[i][j+1]){
                    continue;
                }
                checked[i][j]=true;
                checked[i-1][j]=true;
                checked[i+1][j]=true;
                checked[i][j-1]=true;
                checked[i][j+1]=true;
                int sum = arr[i][j] + arr[i-1][j] + arr[i+1][j] + arr[i][j-1] + arr[i][j+1];
                cal(arr,checked,depth+1,cost+sum);
                checked[i][j]=false;
                checked[i-1][j]=false;
                checked[i+1][j]=false;
                checked[i][j-1]=false;
                checked[i][j+1]=false;
            }
        }
    }
}
