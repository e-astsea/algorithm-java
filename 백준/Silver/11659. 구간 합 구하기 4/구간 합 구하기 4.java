import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);

        String N = st.nextToken();
        String M = st.nextToken();

        int []arr = new int[Integer.parseInt(N)+1];

        String num = br.readLine();
        st = new StringTokenizer(num);


        for(int i=1; i<=Integer.parseInt(N);i++){
            arr[i]=arr[i-1]+Integer.parseInt(st.nextToken());
        }

        for(int j = 0; j<Integer.parseInt(M); j++){
            String input = br.readLine();
            st = new StringTokenizer(input);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            System.out.println(arr[b]-arr[a-1]);
        }
    }

}