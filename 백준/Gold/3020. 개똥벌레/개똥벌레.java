import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, H;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        int[] bot = new int[H + 2];
        int[] top = new int[H + 2];

        for (int i = 0; i < N / 2; i++) {
            bot[Integer.parseInt(br.readLine())]++;
            top[H - Integer.parseInt(br.readLine()) + 1]++;
        }

        for (int i = 1; i <= H; i++) {
            bot[i] += bot[i - 1];
            top[H + 1 - i] += top[H + 2 - i];
        }

        int min = N;
        int cnt = 0;
        for (int i = 1; i <= H; i++) {
            int obs = (bot[H] - bot[i - 1]) + (top[1] - top[i + 1]);
            if (obs < min) {
                min = obs;
                cnt = 1;
            } else if (obs == min)
                cnt++;
        }
        System.out.println(min + " " + cnt);
    }
}
