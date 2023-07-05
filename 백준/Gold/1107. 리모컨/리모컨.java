import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        List<Integer> ls = new ArrayList<>();
        if (M != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                ls.add(Integer.parseInt(st.nextToken()));
            }
        }

        int answer = Math.abs(N - 100);

        for (int i = 0; i < 1000000; i++) {
            if (check(i, ls)) {
                int tmp = Math.abs(N - i) + getLength(i);
                answer = Math.min(answer, tmp);
            }
        }
        System.out.println(answer);
    }

    public static boolean check(int N, List<Integer> ls) {
        if (N == 0) {
            return !ls.contains(0);
        }
        while (N > 0) {
            int num = N % 10;
            if (ls.contains(num)) {
                return false;
            }
            N /= 10;
        }
        return true;
    }

    public static int getLength(int N) {
        if (N == 0) {
            return 1;
        }

        int length = 0;
        while (N > 0) {
            N /= 10;
            length++;
        }

        return length;
    }
}


