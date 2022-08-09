import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int N = Integer.parseInt(str);

        long result=0;
        for(int i=1; i<=N; i++){
            if(i%5==0){
                result++;
            }
            if(i%25==0){
                result++;
            }
            if(i%125==0)
                result++;

        }

        System.out.println(result);

    }
}