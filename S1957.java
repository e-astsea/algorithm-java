import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class S1957 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N=sc.nextInt();
        int []arr = new int[1001];
        for(int i=0; i<=1000; i++){
            arr[i]=1;
        }

        for(int i=0; i<N; i++){
            int k=sc.nextInt();
            arr[k]++;
        }

        for(int i=2; i<=1000; i++){
            if(arr[i]==0){
                continue;
            }
            for(int j=(i+i); j<=1000; j+=i){
                arr[j]=0;
            }
        }
        int count=0;
        for(int k=2; k<=1000; k++){
            if(arr[k]!= 0 && arr[k]!=1){
                count++;
            }
        }
        System.out.println(count);
    }
}

