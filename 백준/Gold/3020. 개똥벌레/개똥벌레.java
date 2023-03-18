import java.io.*;

public class Main {

    static int N, H;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        H = Integer.parseInt(input[1]);

        int[] bot = new int[H + 2];
        int[] top = new int[H + 2];

        for (int i = 0; i < N / 2; i++) {
            bot[Integer.parseInt(br.readLine())]++;
            top[H - Integer.parseInt(br.readLine()) + 1]++;
        }

        for (int i = 1; i <= H; i++) {
            bot[i] += bot[i - 1];
        }

        for (int i = H; i >= 1; i--) {
            top[i] += top[i + 1];
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

        bw.write(min + " " + cnt + "\n");
        bw.flush();

    }

}