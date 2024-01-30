import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[N+1];
        int[] check = new int[100001];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        int count = 0;
        int maxCount = 0;
        while(end<N){
            if(check[arr[end]] < K){
                check[arr[end]]++;
                end++;
                count++;
            } else{
                check[arr[start]]--;
                start++;
                count--;
            }
            maxCount = Math.max(maxCount,count);
        }
        System.out.println(maxCount);
    }
}
