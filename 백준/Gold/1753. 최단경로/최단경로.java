import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Node{
        int v;
        int cost;

        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }
    static List<List<Node>> ls;
    static int[] dist;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());
        ls = new ArrayList<>();
        dist = new int[N+1];
        visited = new boolean[N+1];

        for (int i = 0; i < N+1; i++) {
            ls.add(new ArrayList<>());
            dist[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            ls.get(start).add(new Node(end,w));
        }

        dijkstra(K);

        for (int i = 1; i <= N; i++) {
            System.out.println(dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]);
        }
    }

    private static void dijkstra(int k) {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2)->o1.cost-o2.cost);
        pq.add(new Node(k,0));
        dist[k]=0;

        while(!pq.isEmpty()){
            final Node poll = pq.poll();
            if(visited[poll.v]){
                continue;
            }
            visited[poll.v]= true;

            for (Node next:ls.get(poll.v)) {
                if(!visited[next.v] && dist[next.v] > dist[poll.v]+next.cost){
                    dist[next.v] = dist[poll.v]+next.cost;
                    pq.add(new Node(next.v,dist[next.v]));
                }
            }
        }
    }
}
