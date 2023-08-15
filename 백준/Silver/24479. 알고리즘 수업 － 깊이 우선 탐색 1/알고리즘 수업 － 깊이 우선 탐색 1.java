import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] checked;
    static List<List<Integer>> ls;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        ls = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            ls.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            ls.get(first).add(second);
            ls.get(second).add(first);
        }

        for (int i = 0; i < N; i++) {
            Collections.sort(ls.get(i));
        }

        checked = new int[N+1];
        Arrays.fill(checked,0);
        checked[R]=++answer;

        dfs(R);

        for (int i = 1; i <= N; i++) {
            System.out.println(checked[i]);
        }
    }
    static int answer = 0;
    private static void dfs(int start) {
        for (int i = 0; i < ls.get(start).size(); i++) {
            final int next = ls.get(start).get(i);
            if(checked[next] == 0) {
                checked[next] = ++answer;
                dfs(next);
            }
        }
    }
}
