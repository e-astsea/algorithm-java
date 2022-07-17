import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String s = br.readLine();
        st=new StringTokenizer(s);

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int [][]jewel = new int[N][2];
        int []bag = new int[K];


        for(int i=0; i<N; i++){
            s = br.readLine();
            st = new StringTokenizer(s);
            jewel[i][0]=Integer.parseInt(st.nextToken());
            jewel[i][1]=Integer.parseInt(st.nextToken());
        }
        for(int j=0; j<K; j++){
            s = br.readLine();
            st = new StringTokenizer(s);
            bag[j]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(jewel, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                } else {
                    return o1[0] - o2[0];
                }
            }
        });
        Arrays.sort(bag);

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o2, o1);
            }
        });

        long result=0;
        int j=0;
        for (int i = 0; i < K; i++) {
            while(j < N && jewel[j][0] <= bag[i]) {
                pq.offer(jewel[j++][1]);
            }

            if (!pq.isEmpty()) {
                result += pq.poll();
            }
        }
        System.out.println(result );
    }

}