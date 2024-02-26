import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Bus{
        int v;
        int cost;

        public Bus(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }
    static List<List<Bus>> ls;
    static int[] dist;
    static boolean[] checked;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        ls = new ArrayList<>();
        dist = new int[N+1];
        checked = new boolean[N+1];
        for (int i = 0; i <= N; i++) {
            ls.add(new ArrayList<>());
            dist[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            ls.get(start).add(new Bus(end,w));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        final int start = Integer.parseInt(st.nextToken());
        final int end = Integer.parseInt(st.nextToken());

        dijkstra(start);

        System.out.println(dist[end]);
    }

    private static void dijkstra(int start) {
        PriorityQueue<Bus> pq = new PriorityQueue<>((o1,o2)-> o1.cost-o2.cost);
        pq.add(new Bus(start,0));
        dist[start]=0;
        while(!pq.isEmpty()){
            final Bus poll = pq.poll();

            if(checked[poll.v]){
                continue;
            }
            checked[poll.v]=true;

            for (Bus bus:ls.get(poll.v)) {
                if(!checked[bus.v] && dist[bus.v] > dist[poll.v]+bus.cost){
                    dist[bus.v] = dist[poll.v]+bus.cost;
                    pq.add(new Bus(bus.v,dist[bus.v]));
                }
            }
        }
    }
}
