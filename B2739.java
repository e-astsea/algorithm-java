import java.util.Scanner;

public class B2739 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N;
        N = sc.nextInt();
        for(int i=N; i<=N; i++){
            for(int j=1; j<10; j++){
                System.out.println(i+" * "+j+" = "+i*j);
            }
        }
    }
}
