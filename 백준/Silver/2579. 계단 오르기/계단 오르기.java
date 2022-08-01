import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int N = Integer.parseInt(str);
        int []arr = new int[302];
        int []result = new int[302];
        for(int i=1; i<=N; i++){
            str=br.readLine();
            arr[i]=Integer.parseInt(str);
        }
        result[1]=arr[1];
        result[2]=arr[1]+arr[2];

        for(int i=3; i<=N; i++){
            result[i]=Math.max(result[i-3]+arr[i-1],result[i-2])+arr[i];
        }
        System.out.println(result[N]);
    }
}