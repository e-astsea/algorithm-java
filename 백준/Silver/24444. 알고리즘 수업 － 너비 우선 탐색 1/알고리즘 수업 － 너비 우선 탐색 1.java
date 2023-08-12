import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int R;
    static int[] result;
    static List<List<Integer>> ls;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        ls = new ArrayList<>();
        result = new int[N+1];
        Arrays.fill(result,-1);
        for (int i = 0; i < N+1; i++) {
            ls.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            ls.get(first).add(second);
            ls.get(second).add(first);
        }
        for (int i = 0; i <N+1; i++) {
            Collections.sort(ls.get(i));
        }

        bfs();

        for (int i = 1; i < result.length; i++) {
            if(result[i] == -1){
                System.out.println(0);
            } else {
                System.out.println(result[i]);
            }
        }
    }

    private static void bfs() {
        Queue<Integer> q = new ArrayDeque<>();
        int count = 1;
        q.add(R);
        result[R] = count;
        while(!q.isEmpty()){
            final int now = q.poll();
            for (int i = 0; i < ls.get(now).size(); i++) {
                final int next = ls.get(now).get(i);
                if(result[next] == -1){
                    result[next] = ++count;
                    q.add(next);
                }
            }
        }
    }
}
