import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[][] arr = new boolean[N+1][N+1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            arr[first][second] = true;
            arr[second][first] = true;
        }

        int count =0;
        for (int i = 1; i <= N; i++) {
            for (int j = i+1; j <= N; j++) {
                for (int k = j+1; k <= N; k++) {
                    if(arr[i][j] || arr[j][k] || arr[k][i]){
                        count++;
                    }
                }
            }
        }

        int result = N*(N-1)*(N-2)/6;
        System.out.println(result-count);
    }
}
