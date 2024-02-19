import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<Integer> ls = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            ls.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(ls);
        arr = new boolean[N];
        result = new int[N];
        ans = new LinkedHashSet<>();
        dfs(ls,M,0,0);

        ans.forEach(System.out::print);
    }
    static boolean[] arr;
    static int[] result;
    static LinkedHashSet<String> ans;
    private static void dfs(List<Integer> ls, int max, int depth,int next) {
        if (depth == max) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < max; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            ans.add(sb.toString());
            return;
        }
        for (int i = next; i < ls.size(); i++) {
//            if (arr[i]) {
//                continue;
//            }
            result[depth] = ls.get(i);
//            arr[i] = true;
            dfs(ls, max, depth + 1, i);
//            arr[i] = false;
        }
    }

}
