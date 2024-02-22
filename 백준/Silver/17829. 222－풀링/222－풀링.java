import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(arr);
    }

    private static void dfs(int[][] arr) {
        if(arr.length==1){
            System.out.println(arr[0][0]);
            return;
        }
        int[][] tmp = new int[arr.length/2][arr[0].length/2];
        for (int j = 0; j < arr.length; j+=2) {
            for (int i = 0; i < arr.length; i+=2) {
                tmp[j/2][i/2]=check(arr,j,i);
            }
        }
        dfs(tmp);
    }

    private static int check(int[][] arr, int x, int y) {
        List<Integer> ls = new ArrayList<>();
        for (int i = x; i < 2+x; i++) {
            for (int j = y; j < 2+y; j++) {
                ls.add(arr[i][j]);
            }
        }
        Collections.sort(ls, Comparator.reverseOrder());
        return ls.get(1);
    }
}
