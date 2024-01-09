import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static class Pair{
        int value;
        int index;

        public Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        Deque<Pair> q = new ArrayDeque<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < num; i++) {
            q.add(new Pair(Integer.parseInt(st.nextToken()),i+1));
        }

        while(!q.isEmpty()){
            Pair pair = q.poll();
            System.out.println(pair.index);

            if(q.isEmpty()){
                return;
            }

            if(pair.value>0){
                for (int i = 0; i < pair.value-1; i++) {
                    q.add(q.poll());
                }
            }
            if(pair.value<0){
                for (int i = pair.value; i < 0; i++) {
                    q.addFirst(q.pollLast());
                }
            }
        }
    }
}
