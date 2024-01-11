import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            final int abs1 = Math.abs(o1);
            final int abs2 = Math.abs(o2);

            if(abs1 == abs2){
                return o1>o2 ? 1: -1;
            }
            return abs1-abs2;
        });

        for (int i = 0; i < num; i++) {
            final int x = Integer.parseInt(br.readLine());

            if(x==0){
                final Integer poll = pq.poll();
                if(poll == null){
                    System.out.println("0");
                } else {
                    System.out.println(poll);
                }
            } else {
                pq.add(x);
            }
        }
    }
}
