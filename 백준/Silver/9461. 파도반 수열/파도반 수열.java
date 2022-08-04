import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    static int [][][]checked = new int[61][61][61];
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int T =Integer.parseInt(str);
        long []arr = new long[101];
        arr[1]=1;
        arr[2]=1;
        arr[3]=1;
        for(int j=0; j<T; j++){
            str = br.readLine();
            int N = Integer.parseInt(str);
            for(int i=4; i<=N;i++){
                arr[i]=arr[i-3]+arr[i-2];
            }
            System.out.println(arr[N]);
        }

    }
}