import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int N = Integer.parseInt(str);

        str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        long []arr = new long[N];
        for(int i=0; i<N; i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int count = 0;

        for(int i=0; i<N; i++) {
            int start = 0;
            int end = N - 1;
            while (start < end) {
                int sum = (int)(arr[start] + arr[end]);
                if(sum==arr[i]){
                    if(start != i && end != i) {
                        count++;
                        break;
                    }
                    else if(start == i){
                        start++;
                    }
                    else if(end == i){
                        end--;
                    }
                }
                else if(sum<arr[i]){
                    start++;
                }
                else if(sum>arr[i]){
                    end--;
                }
            }
        }
        System.out.println(count);




    }

}