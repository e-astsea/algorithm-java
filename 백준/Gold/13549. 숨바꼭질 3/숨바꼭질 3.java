import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int K;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[100001];
        Arrays.fill(arr, -1);

        bfs();

        System.out.println(arr[K]);
    }

    private static void bfs() {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(N);
        arr[N] = 0;
        while (!queue.isEmpty()) {
            final int position = queue.poll();

            if(2*position>=0 && 2*position<=100000) {
                if (arr[position * 2] == -1 || arr[position] < arr[position * 2]) {
                    queue.add(position * 2);
                    arr[position * 2] = arr[position];
                }
            }

            if(position-1>=0 && position-1<=100000) {
                if (arr[position - 1] == -1 || arr[position] + 1 < arr[position - 1]) {
                    queue.add(position - 1);
                    arr[position - 1] = arr[position] + 1;
                }
            }

            if(position+1>=0 && position+1<=100000) {
                if (arr[position + 1] == -1 || arr[position] + 1 < arr[position + 1]) {
                    queue.add(position + 1);
                    arr[position + 1] = arr[position] + 1;
                }
            }
        }
    }
}
