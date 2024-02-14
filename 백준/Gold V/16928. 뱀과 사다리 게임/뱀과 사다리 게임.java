import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[101];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=i;
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[Integer.parseInt(st.nextToken())]=Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            arr[Integer.parseInt(st.nextToken())]=Integer.parseInt(st.nextToken());
        }

        checked = new int[101];
        bfs(1);
        System.out.println(checked[100]);
    }
    static int[] arr;
    static int[] checked;
    private static void bfs(int num) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(num);
        checked[num]=0;
        while(!q.isEmpty()) {
            int visitedNum = q.poll();

            for (int i = 1; i < 7; i++) {
                int newNum = visitedNum+i;
                if(newNum>100){
                    continue;
                }

                if(checked[arr[newNum]] ==0){
                    q.offer(arr[newNum]);
                    checked[arr[newNum]] = checked[visitedNum]+1;
                }
            }
        }

    }
}
