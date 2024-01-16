import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean[] arr = new boolean[N+1];
        int count =0;
        for (int i = 2; i <=N ; i++) {
            for (int j = 1; j*i <= N ; j++) {
                if(arr[i*j]){
                    continue;
                }
                arr[i*j] = true;
                count++;
                if(count == M){
                    System.out.println(i*j);
                    return;
                }
            }
        }
    }
}
