import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int a;
    static int b;
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        List<List<Integer>> ls = new ArrayList<>();

        for (int i = 0; i < n + 1; i++) {
            ls.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            final int first = Integer.parseInt(st.nextToken());
            final int second = Integer.parseInt(st.nextToken());
            ls.get(first).add(second);
            ls.get(second).add(first);
        }

        final int result = method(ls, a, b);

        System.out.println(result);
    }

    private static int method(final List<List<Integer>> ls, int a, int b) {
        int[] result = new int[n + 1];
        Arrays.fill(result, -1);

        Queue<Integer> que = new ArrayDeque<>();
        que.add(a);
        result[a] = 0;
        while (!que.isEmpty()) {
            int now = que.poll();
            for (int i = 0; i < ls.get(now).size(); i++) {
                int next = ls.get(now).get(i);
                if (result[next] == -1) {
                    result[next] = result[now] + 1;
                    que.add(next);
                }
            }
        }
        return result[b];
    }
}
