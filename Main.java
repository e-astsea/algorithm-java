import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     int N, M;
     int result=0;
     N= sc.nextInt();
     M= sc.nextInt();
     int [][]cost = new int[M][2];

    for(int i=0; i<M; i++) {
        cost[i][0] = sc.nextInt();
        cost[i][1] = sc.nextInt();
    }

    int max = cost[0][0];
    for(int j=1; j<M; j++){
        if(cost[j][0]<max){
            max = cost[j][0];
        }
    }

    int max_1 = cost[0][1];
    for(int j=1; j<M; j++){
        if(cost[j][1]<max_1){
            max_1 = cost[j][1];
        }
    }

    if(max_1*6<max){
        result += max_1*N;
    }
    else {
        if ((N / 6) > 0) {
            result += (max * (N / 6));
            N %= 6;
        }
        if (max_1 * N > max) {
            result += max;
        } else
            result += (max_1 * N);
    }

        System.out.println(result);
    }
}

