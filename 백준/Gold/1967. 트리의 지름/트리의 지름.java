import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static boolean[] checked;
    static int result = 0;
    static class Node{
        int child=-1;
        int value;

        public Node(int child, int value) {
            this.child = child;
            this.value = value;
        }
    }
    static List<List<Node>> ls = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N+1; i++) {
            ls.add(new ArrayList<>());
        }

        for (int i = 0; i < N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            ls.get(parent).add(new Node(child,value));
            ls.get(child).add(new Node(parent,value));
        }

        for (int i = 1; i <= N; i++) {
            checked = new boolean[N+1];
            dfs(i, 0);
        }
        System.out.println(result);
    }

    private static void dfs(int i, int value) {
        checked[i]=true;
        if(value>result){
            result = value;
        }
        for (int j = 0; j < ls.get(i).size(); j++) {
            if(ls.get(i).get(j).child==-1 || checked[ls.get(i).get(j).child]){
                continue;
            }
            dfs(ls.get(i).get(j).child, value+ls.get(i).get(j).value);
        }
    }
}
