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

        int[] arr = new int[50001];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left=0;
        int right=0;
        int count = arr[0]%2==0?0:1;
        int max = arr[0]%2==0?1:0;
        int even = arr[0]%2==0?1:0;
        while(right<N-1){
            if(arr[right+1] %2 !=0){
                right++;
                count++;
            } else{
                right++;
                even++;
            }

            if(count>K){
                left++;
                if(arr[left-1] % 2 !=0){
                    count--;
                } else{
                    even--;
                }
            }
            max = Math.max(max, even);
        }
        System.out.println(max);
    }
}
