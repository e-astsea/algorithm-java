import java.util.Arrays;
import java.util.Scanner;

public class S2217 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int []arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i]=sc.nextInt();
        }
        Arrays.sort(arr);
        int count =1;
        int result =0;
        for(int i=N-1; i>=0; i--){
            if(result<arr[i]*(count))
                result = (arr[i]*(count++));
            else{
                count++;
            }
        }
        System.out.println(result);
    }
}
