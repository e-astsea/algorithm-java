import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static class Pair{
        int x;
        int y;

        public Pair(final int x, final int y) {
            this.x = x;
            this.y = y;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        final int N = Integer.parseInt(br.readLine());
        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            pairs.add(new Pair(x,y));
        }

        Collections.sort(pairs, ((o1, o2) -> o1.x -o2.x));
        int time = 0;
        for (int i = 0; i < N; i++) {
            int start = pairs.get(i).x;
            int wait = pairs.get(i).y;

            if(start>time){
                time+=(start-time);
            }

            time+=wait;
        }
        System.out.println(time);
    }
}
