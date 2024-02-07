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
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer> ls = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            ls.add(Integer.parseInt(st.nextToken()));
        }

        int start = 1;
        int end = 1000000000;
        int re = -1;
        while(start<=end){
            int mid = (start+end)/2;

            int result = 0;
            for (Integer num: ls) {
                result += num/mid;
            }

            if(result>=N){
                re = mid;
                start = mid+1;
            } else{
                end = mid-1;
            }
        }
        System.out.println(re != -1 ? re : 0);
    }
}
