
import java.util.*;

public class G11000 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int [][]T = new int[N][2];

        for(int i=0; i<N; i++){
            T[i][0]=sc.nextInt();
            T[i][1]=sc.nextInt();
        }

        Arrays.sort(T, (o1,o2) -> {
            if(o1[0] == o2[0]){
                return o1[1] - o2[1];
            }
            else
                return o1[0] - o2[0];
        });



        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(T[0][1]);
        for(int i = 1; i < N; i++) {
            if(pq.peek() <= T[i][0])
                pq.poll();
            pq.add(T[i][1]);
        }
        System.out.println(pq.size());

    }
}


