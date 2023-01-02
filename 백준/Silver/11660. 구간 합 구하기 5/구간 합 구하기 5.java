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

        int [][]arr = new int[Integer.parseInt(N)+1][Integer.parseInt(N)+1];

        for(int i=1; i<=Integer.parseInt(N);i++){
            String num = br.readLine();
            st = new StringTokenizer(num);
            for(int j=1; j<=Integer.parseInt(N); j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        int [][]sum = new int[Integer.parseInt(N)+1][Integer.parseInt(N)+1];
        for(int i=1; i<=Integer.parseInt(N);i++){
            for(int j=1; j<=Integer.parseInt(N); j++){
                sum[i][j]=sum[i-1][j]+sum[i][j-1]-sum[i-1][j-1]+arr[i][j];
            }
        }
        for(int i=0; i<Integer.parseInt(M); i++){
            String num1 = br.readLine();
            st = new StringTokenizer(num1);
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            System.out.println(sum[x2][y2]-sum[x1-1][y2]-sum[x2][y1-1]+sum[x1-1][y1-1]);
        }



    }

}