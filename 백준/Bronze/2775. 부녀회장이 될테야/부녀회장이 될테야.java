import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int[][] apartment = new int[15][15];
        for (int i = 1; i < 15; i++) {
            apartment[0][i] = i;
        }

        for (int i = 1; i < 15; i++) {
            for (int j = 1; j < 15; j++) {
                apartment[i][j] = apartment[i-1][j] + apartment[i][j-1];
            }
        }

        for (int i = 0; i < T; i++) {
            int K = Integer.parseInt(br.readLine());
            int N = Integer.parseInt(br.readLine());
            System.out.println(apartment[K][N]);
        }
    }
}
