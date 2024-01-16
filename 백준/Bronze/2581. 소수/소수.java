import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        int min = Integer.MAX_VALUE;
        int sum = 0;

        for (int i = M; i <= N; i++) {
            boolean flag = false;
            for (int j = 2; j*j <= i; j++) {
                if(i%j==0){
                    flag = true;
                    break;
                }
            }
            if(i==1){
                continue;
            }
            if (!flag){
                min = Math.min(min,i);
                sum += i;
            }
        }
        if(min==Integer.MAX_VALUE){
            System.out.println("-1");
        } else {
            System.out.println(sum);
            System.out.println(min);
        }
    }
}
