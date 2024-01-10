import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static class Pair{
        int index;
        int value;

        public Pair(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        Deque<Pair> deque = new ArrayDeque<>();

        for (int i = 1; i <= num; i++) {
            final int now = Integer.parseInt(st.nextToken());
            if (deque.isEmpty()){
                System.out.print("0 ");
                deque.add(new Pair(i,now));
            } else {    
                boolean flag = false;
                while(!deque.isEmpty()) {
                    if (deque.peekLast().value > now) {
                        flag = true;
                        System.out.print(deque.peekLast().index+" ");
                        deque.addLast(new Pair(i,now));
                        break;
                    } else {
                        deque.pollLast();
                    }
                }
                if (!flag){
                    deque.addLast(new Pair(i,now));
                    System.out.print("0 ");
                }
            }
        }
    }
}
