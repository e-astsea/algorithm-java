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

        int[] arr = new int[1000001];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        int check = 0;
        int count = 0;
        int maxCount = 0;
        while(end<N){
            if(check>K){
                if(arr[start]%2==0){
                    start++;
                    count--;
                } else{
                    start++;
                    check--;
                }
                continue;
            }
         if(arr[end]%2==0){
            end++;
            count++;
        } else if(arr[end]%2!=0){
            end++;
            check++;
        }


            maxCount = Math.max(maxCount,count);

        }
        System.out.println(maxCount);
    }
}
