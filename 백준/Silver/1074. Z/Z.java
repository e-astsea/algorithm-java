import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        find((int) (Math.pow(2, N)), r, c);
        System.out.println(answer);
    }

    private static void find(int N, int r, int c) {
        if (N == 1) {
            return;
        }
        int midColumn = N / 2;
        int midRow = N / 2;

        if (r < midRow && c < midColumn) {
            find(N / 2, r, c);
        } else if (r < midRow && c >= midColumn) {
            answer += N * N / 4;
            find(N / 2, r, c - midColumn);
        } else if (r >= midRow && c < midColumn) {
            answer += N * N / 4 * 2;
            find(N / 2, r - midRow, c);
        } else {
            answer += N * N / 4 * 3;
            find(N / 2, r - midRow, c - midColumn);
        }
    }
}
