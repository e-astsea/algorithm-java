import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sa = br.readLine();
        int N = Integer.parseInt(sa);

        for(int i=0; i<N; i++) {
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s, " ", true);
            while(st.hasMoreTokens()) {
                StringBuffer sb = new StringBuffer(st.nextToken());
                String rs = sb.reverse().toString();
                System.out.print(rs);
            }
            System.out.println();


        }






    }

}