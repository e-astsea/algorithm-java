import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int[][] arr;
    private static int[][] result;
    private static int[][] fin;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Long B = Long.parseLong(st.nextToken());

        arr = new int[N][N];
        result = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken())%1000;
                result[i][j] = arr[i][j];
            }
        }

        fin = calculate(B);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(fin[i][j]+" ");
            }
            System.out.println();
        }
    }

    static public int[][] calculate(long B) {
        if (B == 1) {
            return arr;
        }
        int[][] temp = calculate(B / 2);
        if (B % 2 == 1) {
            return pow(B,N,temp, pow(B,N,temp, arr));
        } else {
            return pow(B,N,temp, temp);
        }
    }

    private static int[][] pow(Long B, int N, int[][] origin, int[][] result) {
        fin = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    fin[i][j] += (origin[i][k] * result[k][j]);
                }
                fin[i][j] %= 1000;
            }
        }
        return fin;
    }
}
