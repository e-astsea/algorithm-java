import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<List<Integer>> ls = new ArrayList<>();
        List<List<Integer>> ls2 = new ArrayList<>();
        for (int i = 0; i < N+1; i++) {
            ls.add(new ArrayList<>());
            ls2.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            ls.get(first).add(second);
            ls2.get(second).add(first);
        }
        int[][] result = new int[N+1][2];
        for (int i = 1; i <= N; i++) {
            checked = new boolean[N+1];
            dfs(ls, i);
            int count = 0;
            for (int j = 0; j < checked.length; j++) {
                if(checked[j]){
                    count++;
                }
            }
            result[i][0]=count;

            checked = new boolean[N+1];
            dfs(ls2, i);
            count = 0;
            for (int j = 0; j < checked.length; j++) {
                if(checked[j]){
                    count++;
                }
            }
            result[i][1]=count;

        }

        int re = 0;
        for (int i = 0; i <result.length; i++) {
            if(result[i][0]+result[i][1] == N+1){
                re++;
            }
        }
        System.out.println(re);
    }
    static boolean[] checked;
    private static void dfs(List<List<Integer>> ls, int i) {

        if(checked[i]){
            return;
        }

        checked[i]= true;
        for (int j = 0; j < ls.get(i).size(); j++) {
            dfs(ls,ls.get(i).get(j));
        }
    }
}
/*
1 5
2
3 4
4 2 6
5 2 4
6
4는3개

1
2 4 5
3
4 3 5
5 1
6 4
4는4
 */
