import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long []length = new long[N-1];
        long []cost = new long[N];
        for(int i=0; i<N-1; i++){
            length[i]=sc.nextInt();
        }
        for(int i=0; i<N; i++){
            cost[i]=sc.nextInt();
        }
        long mincost = cost[0];
        long oil_cost=0;

        for(int i=0; i<N-1; i++){
            if(mincost>cost[i]){
                mincost=cost[i];
            }
            oil_cost += mincost * length[i];

        }
        System.out.println(oil_cost);
    }
}
