import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static int[] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<List<Integer>> ls = new ArrayList<>();
        result = new int[N+1];
        for (int i = 0; i <= N; i++) {
            ls.add(new ArrayList<>());
        }

        for (int i = 0; i < N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            ls.get(first).add(second);
            ls.get(second).add(first);
        }

        result[1] = -1;
        dfs(ls,1);

        for (int i = 2; i <=N ; i++) {
            System.out.println(result[i]);
        }
    }

    private static void dfs(List<List<Integer>> ls, int num) {
        for (int i = 0; i < ls.get(num).size(); i++) {
            if(result[ls.get(num).get(i)]==0) {
                result[ls.get(num).get(i)] = num;
            } else{
                continue;
            }
           dfs(ls, ls.get(num).get(i));
        }
    }
}
