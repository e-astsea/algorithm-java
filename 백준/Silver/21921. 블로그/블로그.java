import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[] arr = new int[250001];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        int result = arr[0];
        int maxResult = 0;
        int count = 1;
        while(end<N){
            if(end-start<X-1){
                end++;
                result += arr[end];
            } else if (end-start>X-1) {
                result -= arr[start];
                start++;
            } else{
                end++;
                result+=arr[end];
                result-=arr[start];
                start++;
            }
            if(maxResult < result){
                count = 1;
            } else if(maxResult == result){
                count++;
            }
            maxResult = Math.max(maxResult,result);
        }
        if(maxResult ==0){
            System.out.println("SAD");
        } else{
            System.out.println(maxResult);
            System.out.println(count);
        }
    }
}
