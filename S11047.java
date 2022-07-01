import java.util.Scanner;

public class S11047 {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int N=sc.nextInt(), K= sc.nextInt();
            int [] arr = new int[N];

            for(int i=0; i<N; i++){
                arr[i] = sc.nextInt();
            }
            int result =0;
            for(int j=N-1; j>=0; j--){
                result += K/arr[j];
                K %= arr[j];
            }
            System.out.println(result);
        }

}
