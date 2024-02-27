import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[][] arr = new int[N+1][N+1];

        for (int i = 0; i < N+1; i++) {
            for (int j = 0; j < N+1; j++) {
                arr[i][j] = 987654321;
                if(i==j){
                    arr[i][j]=0;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            arr[start][end] = Math.min(arr[start][end],w);
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (arr[i][j] > arr[i][k] + arr[k][j]) {
                        arr[i][j] = arr[i][k] + arr[k][j];
                    }
                }
            }
        }
        for (int i = 1; i < N+1; i++) {
            for (int j = 1; j < N+1; j++) {
                if(arr[i][j]==987654321){
                    arr[i][j]=0;
                }
            }
        }

        for (int i = 1; i < N+1; i++) {
            for (int j = 1; j < N+1; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println("");
        }
    }
}
