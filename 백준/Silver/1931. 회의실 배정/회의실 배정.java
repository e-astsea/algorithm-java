import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int [][]arr = new int[N][2];

        for(int i=0; i<N; i++){
            arr[i][0]=sc.nextInt();
            arr[i][1]=sc.nextInt();
        }

        Arrays.sort(arr, (o1,o2) -> {
            if(o1[1] == o2[1]){
                return Integer.compare(o1[0],o2[0]);
            }
            else
                return Integer.compare(o1[1],o2[1]);
        });
        
        int end=arr[0][1];
        int count=0;

        for(int i=1; i<N; i++){
            if(end<=arr[i][0]){
                end = arr[i][1];
                count++;
            }
        }
        System.out.println(count+1);
    }
}

