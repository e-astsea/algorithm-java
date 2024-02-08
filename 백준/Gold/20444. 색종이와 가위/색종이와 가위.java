import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        long start = 0;
        long end = N;
        boolean flag = false;
        while(start<=end){
            long mid = (start+end)/2;

            long result = (mid+1)*(N-mid+1);
            if(result == M){
                flag=true;
                break;
            } else if(result<M){
                start = mid+1;
            } else{
                end = mid-1;
            }
        }
        if(flag) {
            System.out.println("YES");
        } else{
            System.out.println("NO");
        }
    }
}
