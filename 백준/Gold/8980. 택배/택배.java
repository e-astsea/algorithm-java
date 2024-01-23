import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Delivery{
        int start;
        int end;
        int box;

        public Delivery(int start, int end, int box) {
            this.start = start;
            this.end = end;
            this.box = box;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(br.readLine());

        PriorityQueue<Delivery> pq = new PriorityQueue<>((o1, o2) -> {
            if(o1.end == o2.end){
                return o1.start>o2.start ? 1:-1;
            }
            return o1.end>o2.end?1:-1;
        });

        int[] map = new int[N+1];
        for (int i = 0; i < map.length; i++) {
            map[i] = C;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            pq.add(new Delivery(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }

        int size = pq.size();
        int result = 0;
        for (int i = 0; i < size; i++) {
            Delivery del = pq.poll();

            int min = C;
            for (int j = del.start; j < del.end; j++) {
                min = Math.min(min,map[j]);
            }
            int minMinus = Math.min(min, del.box);
            for (int j = del.start; j < del.end; j++) {
                map[j] -= minMinus;
            }
            result += minMinus;
        }
        System.out.println(result);
    }
}
