import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static int[][] tmp;
    public static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        tmp = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            tmp[i][0] = t;
            tmp[i][1] = p;
        }
        result = 0;
        dfs(0,0);
        System.out.println(result);
    }
    public static void dfs(int day, int answer){
        if(day >= N){
            result = Math.max(result, answer);
            return;
        }
        if(day + tmp[day][0] <= N) {
            dfs(day + tmp[day][0], answer + tmp[day][1]);
        }
        dfs(day+1, answer);


    }
}
