import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    static int [][][]checked = new int[61][61][61];
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int T = Integer.parseInt(str);

        long []arr = new long[1000001];
        arr[1]=1;
        arr[2]=2;
        arr[3]=4;


        for(int j=0; j<T; j++) {
            str = br.readLine();
            int N = Integer.parseInt(str);
            for (int i = 4; i <= N; i++) {
                arr[i] = (arr[i - 1] + arr[i - 2] +arr[i-3]) % 1000000009;
            }
            System.out.println(arr[N]);
        }

    }
}