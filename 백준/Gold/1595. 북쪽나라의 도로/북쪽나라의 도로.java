import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class Node{
        int end;
        int length;

        public Node(final int end, final int length) {
            this.end = end;
            this.length = length;
        }
    }

    static List<List<Node>> ls;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ls = new ArrayList<>();
        for (int i = 0; i < 10001; i++) {
            ls.add(new ArrayList<>());
        }
        String line;
        while((line = br.readLine()) != null && !line.isEmpty()) {
            StringTokenizer st = new StringTokenizer(line);
            int first = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());

            ls.get(first).add(new Node(end,length));
            ls.get(end).add(new Node(first,length));
        }

        for (int i = 1; i < 10001; i++) {
            visited = new boolean[10001];
            visited[i] = true;
            dfs(i, 0);
        }

        System.out.println(count);
    }
    static int count = 0;
    private static void dfs(final int root, int depth) {
        count = Math.max(count,depth);
        final List<Node> nodes = ls.get(root);
        for (int i = 0; i < nodes.size(); i++) {
            final int end = nodes.get(i).end;
            final int length = nodes.get(i).length;
            if(visited[end]){
                continue;
            }
            visited[end] = true;
            dfs(end,depth+length);
        }
    }
}
