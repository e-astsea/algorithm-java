import java.util.*;

public class G1715 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<N; i++){
            pq.add(sc.nextInt());
        }
        int result=0;

        while(!pq.isEmpty()){
            int re = 0;
            if(pq.size()>1)
                re = pq.poll()+pq.poll();
            else{
                result+=re;
                break;
            }
            result += re;
            pq.add(re);
        }
        System.out.println(result);

    }
}


