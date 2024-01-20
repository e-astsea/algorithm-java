import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int five = N/5;
        int two = 0;

        int count = Integer.MAX_VALUE;
        for (int i = 0; i <= five; i++) {
            int result = i;
            int num = N-5*i;

            if(num%2==0){
                result += num/2;
                count = Math.min(count,result);
            }
        }

        if(count == Integer.MAX_VALUE){
            System.out.println("-1");
        } else{
            System.out.println(count);
        }
    }
}
