import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        boolean[] isBroken = new boolean[N + 1];
        for (int i = 0; i < B; i++) {
            int brokenSignal = Integer.parseInt(br.readLine());
            isBroken[brokenSignal] = true;
        }
        int result = Integer.MAX_VALUE;
        int count = 0;

        for (int j = 1; j <= K; j++) {
            if(isBroken[j]){
                count++;
            }
        }
        result = Math.min(count,result);

        for (int i = K+1; i <= N; i++) {
            if(isBroken[i]){
                count++;
            }
            if(isBroken[i-K]){
                count--;
            }
            result = Math.min(count,result);
        }
        System.out.println(result);
    }
}
