import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int F;
    static int S;
    static int G;
    static int U;
    static int D;
    static boolean[] checked = new boolean[1000001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        for (int i = 0; i < 1000001; i++) {
            checked[i] = true;
        }

        bfs(S);
    }

    private static void bfs(int S) {
        Queue<Integer> q = new ArrayDeque<>();
        int answer = 0;
        q.add(S);
        checked[S]=false;

        while(!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int num = q.poll();
                if (num == G) {
                    System.out.println(answer);
                    return;
                }

                if (num + U <= F && checked[num + U]) {
                    q.add(num + U);
                    checked[num + U] = false;
                }
                if (num - D > 0 && checked[num - D]) {
                    q.add(num - D);
                    checked[num - D] = false;
                }
            }
            answer++;
        }
        System.out.println("use the stairs");
    }
}
