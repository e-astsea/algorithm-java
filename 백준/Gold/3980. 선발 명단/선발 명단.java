import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            Max = 0;
            int[][] arr = new int[11][11];
            for (int j = 0; j < 11; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 0; k < 11; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            checked = new boolean[11];
            dfs(arr, 0, 0);
            System.out.println(Max);
        }
    }
    static int Max;
    static boolean[] checked;
    private static void dfs(int[][] arr, int result, int index) {
        if(index==11){
            Max = Math.max(Max,result);
            return;
        }

        for (int i = 0; i < 11; i++) {
            if(arr[index][i] !=0 && !checked[i]) {
                checked[i] = true;
                dfs(arr, result + arr[index][i], index + 1);
                checked[i]= false;
            }
        }
    }
}
