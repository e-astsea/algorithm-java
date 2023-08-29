import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int answer = 0;
    static int del,N;
    static List<List<Integer>> ls;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        ls = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            ls.add(new ArrayList<>());
        }
        int root = -1;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            final int node = Integer.parseInt(st.nextToken());
            if(node==-1){
                root = i;
            }else {
                ls.get(node).add(i);
            }
        }
        del = Integer.parseInt(br.readLine());
        if(del == root){
            System.out.println(0);
            return;
        }
        dfs(root);

        System.out.println(answer);
    }

    private static void dfs(int now) {
        int nodes = 0;
        for (int i = 0; i < ls.get(now).size(); i++) {
            int next = ls.get(now).get(i);
            if(next != del) {
                nodes++;
                dfs(next);
            }
        }
        if(nodes == 0){
            answer++;
        }
    }
}
