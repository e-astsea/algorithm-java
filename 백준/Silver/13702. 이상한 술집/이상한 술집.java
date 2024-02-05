import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken().trim());
        int M = Integer.parseInt(st.nextToken().trim());

        List<Integer> ls = new ArrayList<>();
        long max = 0;
        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(br.readLine().trim());
            ls.add(value);
            max = Math.max(max,value);
        }

        long start = 1;
        long end = max;
        while(start<=end){
            long mid = (start+end)/2;

            long result = 0;
            for (int i = 0; i < ls.size(); i++) {
                result += ls.get(i)/mid;
            }

            if(result>=M){
                start = mid+1;
            } else{
                end = mid-1;
            }
        }
        System.out.println(end);
    }
}
