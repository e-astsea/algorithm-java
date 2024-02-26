import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Node{
        int node;
        int cost;

        public Node(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }
    static List<List<Node>> ls;
    static List<List<Node>> ls2;
    static boolean[] checked;
    static int[] dist;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        ls = new ArrayList<>();
        ls2 = new ArrayList<>();

        for (int i = 0; i <=N; i++) {
            ls.add(new ArrayList<>());
            ls2.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            ls.get(start).add(new Node(end,w));
            ls2.get(end).add(new Node(start,w));
        }
        int max = 0;
        for (int i = 1; i <= N; i++) {

            dijakstra(i,ls);
            int go = dist[X];

            dijakstra(X,ls);
            int come = dist[i];
            max =Math.max(go+come,max);
        }
        System.out.println(max);
    }

    private static void dijakstra(int start,List<List<Node>> ls) {
        checked = new boolean[N+1];
        dist = new int[N+1];
        Arrays.fill(dist,Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>(((o1, o2) -> o1.cost-o2.cost));
        pq.add(new Node(start,0));
        dist[start]=0;
        while(!pq.isEmpty()){
            final Node now = pq.poll();

            if(checked[now.node]){
                continue;
            }
            checked[now.node]=true;

            for (Node next :ls.get(now.node)) {
                if(!checked[next.node] && dist[next.node] > dist[now.node]+next.cost){
                    dist[next.node] = dist[now.node]+next.cost;
                    pq.add(new Node(next.node, dist[next.node]));
                }
            }
        }
    }
}
