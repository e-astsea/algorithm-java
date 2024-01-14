import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static List<List<Integer>> ls;
    public static boolean[] checked;
    public static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        ls = new ArrayList<>();
        checked = new boolean[N+1];
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

        dfs(1,0);

        System.out.println(count%2==1 ? "Yes":"No");
    }

    private static void dfs(int start, int depth) {
        for (int i = 0; i < ls.get(start).size(); i++) {
            if(checked[ls.get(start).get(i)]){
                if(ls.get(start).size()==1){
                    count+=depth;
                }
                continue;
            }

            checked[start]=true;
            dfs(ls.get(start).get(i),depth+1);
        }
    }
}
