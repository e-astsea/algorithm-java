import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int first = Integer.parseInt(st.nextToken());
        int second = Integer.parseInt(st.nextToken());

        System.out.println(first+second-gcd(first,second));
    }

    private static int gcd(int first, int second) {
        if(first%second==0){
            return second;
        } else{
            return gcd(second,first%second);
        }
    }
}
