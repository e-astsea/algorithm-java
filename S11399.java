import java.util.Arrays;
import java.util.Scanner;

public class S11399 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int []arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int result=0;
        for(int j=0; j<N; j++){
            result += (N-j)*arr[j];
        }
        System.out.println(result);
    }
}
