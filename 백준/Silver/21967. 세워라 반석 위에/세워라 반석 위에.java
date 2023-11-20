import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Deque<Integer> q = new ArrayDeque<>();
        int[] arr = new int[11];
        int ans = 0;
        for (int i = 0; i < num; i++) {
            int a = Integer.parseInt(st.nextToken());

            arr[a]++;
            q.addLast(a);

            while (check(arr) > 2 && !q.isEmpty()) {
                int b = q.pollFirst();
                arr[b]--;
            }

            ans = Math.max(ans, q.size());
        }
        System.out.println(ans);
    }

    private static int check(int[] arr) {
        int a = 0;
        for (int i = 1; i <= 10; i++) {
            if (arr[i] > 0) {
                a = i;
                break;
            }
        }

        int b = 0;
        for (int i = 10; i >= 1; i--) {
            if (arr[i] > 0) {
                b = i;
                break;
            }
        }

        return b - a;
    }
}
