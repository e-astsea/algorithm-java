import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();

        long count =0;
        long result=0;
        for(long i=1; i<=N; i++) {
            result +=i;

            if(result>N){
                break;
            }
            count++;
        }
        System.out.println(count);
    }
}
