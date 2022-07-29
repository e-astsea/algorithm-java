import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int T = Integer.parseInt(str);

        int result =1;

        for(int i=1; i<=T; i++){
            result*=i;
        }
        System.out.println(result);

    }
}