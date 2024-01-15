import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static boolean[] checked;
    static int count = 0;
    static int delNode = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<List<Integer>> ls = new ArrayList<>();
        checked = new boolean[N];
        for (int i = 0; i < N; i++) {
            ls.add(new ArrayList<>());
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int root = 0;
        for (int i = 0; i < N; i++) {
            final int node = Integer.parseInt(st.nextToken());
            if(node != -1){
                ls.get(node).add(i);
            } else{
                root = i;
            }
        }

        delNode = Integer.parseInt(br.readLine());
        checked[delNode]=true;
        dfs(ls,root);
        if(delNode==root){
            System.out.println("0");
        } else {
            System.out.println(count);
        }
    }

    private static void dfs(List<List<Integer>> ls, int now) {
        if((ls.get(now).size()==0)|| (ls.get(now).size()==1&& ls.get(now).get(0) == delNode)){
            count++;
        }
        checked[now] = true;
        for (int i = 0; i < ls.get(now).size(); i++) {
            if(checked[ls.get(now).get(i)]){
                continue;
            }
            dfs(ls,ls.get(now).get(i));
        }
    }
}
