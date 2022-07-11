import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S1940 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int N = Integer.parseInt(str);
        str = br.readLine();
        int M = Integer.parseInt(str);
        str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int []arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int start=0;
        int end = N-1;
        int count=0;
        while(start < end){
            int sum = arr[start]+arr[end];
            if(sum==M){
                count++;
                start++;
                end--;
            }
            else if(sum<M){
                start++;
            }
            else if(sum>M){
                end--;
            }
        }
        System.out.println(count);




    }

}