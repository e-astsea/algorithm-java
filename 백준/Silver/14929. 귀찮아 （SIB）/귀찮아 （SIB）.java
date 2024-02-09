import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] ls = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum=0;
        int[] sumLs = new int[N+1];
        for (int i = 1; i <= N; i++) {
            ls[i] = Integer.parseInt(st.nextToken());
            sumLs[i]= ls[i]+sumLs[i-1];
        }

        long result = 0;

        for (int i = 1; i < N; i++) {
            int sums = sumLs[N]-sumLs[i];
            result += ls[i]*sums;
        }
        System.out.println(result);
    }
}
