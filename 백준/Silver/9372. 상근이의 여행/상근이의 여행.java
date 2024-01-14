import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static boolean[] checked;
    public static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            List<List<Integer>> ls = new ArrayList<>();
            checked = new boolean[N+1];
            count = 0;
            for (int j = 0; j <= N; j++) {
                ls.add(new ArrayList<>());
            }

            for (int j = 0; j < M; j++) {
                st = new StringTokenizer(br.readLine());
                int first = Integer.parseInt(st.nextToken());
                int second = Integer.parseInt(st.nextToken());
                ls.get(first).add(second);
                ls.get(second).add(first);
            }

            checked[1]=true;
            dfs(ls,1);
            System.out.println(count);
        }
    }

    private static void dfs(List<List<Integer>> ls, int i) {
        for (int j = 0; j < ls.get(i).size(); j++) {
            if(checked[ls.get(i).get(j)]){
                continue;
            }
            count++;
            checked[ls.get(i).get(j)] = true;
            dfs(ls,ls.get(i).get(j));
        }
    }
}
