import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(bufferedReader.readLine());

        long[] length = new long[N - 1];
        long[] cost = new long[N];

        st = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N - 1; i++) {
            length[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }
        
        long mincost = cost[0];
        long oil_cost = 0;

        for (int i = 0; i < N - 1; i++) {
            if (mincost > cost[i]) {
                mincost = cost[i];
            }
            oil_cost += mincost * length[i];
        }
        
        System.out.println(oil_cost);
    }
}
