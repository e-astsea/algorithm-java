import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        LinkedList<Integer> deq = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            deq.add(i);
        }

        int M = Integer.parseInt(st.nextToken());

        List<Integer> ls = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            ls.add(Integer.parseInt(st.nextToken()));
        }

        int count = 0;
        for (int i = 0; i < ls.size(); i++) {
            final Integer num = ls.get(i);
            final int targetIdx = deq.indexOf(num);
            int halfIdx;
            if (deq.size() % 2 == 0) {
                halfIdx = deq.size() / 2 - 1;
            } else {
                halfIdx = deq.size() / 2;
            }

            if (targetIdx <= halfIdx) {
                for (int j = 0; j < targetIdx; j++) {
                    deq.offerLast(deq.pollFirst());
                    count++;
                }
            } else {
                for (int j = 0; j < deq.size() - targetIdx; j++) {
                    deq.offerFirst(deq.pollLast());
                    count++;
                }
            }
            deq.pollFirst();
        }
        System.out.println(count);
    }
}
