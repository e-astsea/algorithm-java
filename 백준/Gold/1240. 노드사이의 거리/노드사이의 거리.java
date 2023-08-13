import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Pair{
        int x;
        int y;

        public Pair(final int x, final int y) {
            this.x = x;
            this.y = y;
        }
    }
    static List<List<Integer>> ls;
    static int N;
    static int[][] length;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());

        ls = new ArrayList<>();
        length = new int[N + 1][N + 1];
        for (int i = 0; i <= N; i++) {
            Arrays.fill(length[i],0);
        }

        for (int i = 0; i <= N; i++) {
            ls.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            int leng = Integer.parseInt(st.nextToken());

            ls.get(first).add(second);
            ls.get(second).add(first);
            length[first][second] = leng;
            length[second][first] = leng;
        }

        Queue<Pair> queue = new ArrayDeque<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            queue.add(new Pair(first,second));
            bfs(queue);
        }
    }

    private static void bfs(final Queue<Pair> queue) {
        int [] checked = new int[N+1];
        Arrays.fill(checked,-1);
        int start = queue.peek().x;
        int end = queue.peek().y;

        checked[start] = 0;

        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            for (int i = 0; i < ls.get(pair.x).size(); i++) {
                final int now = ls.get(pair.x).get(i);
                if(checked[now] == -1){
                    checked[now] = checked[pair.x]+length[pair.x][now];
                    queue.add(new Pair(now,i));
                }
            }
        }
        System.out.println(checked[end]);
    }
}
