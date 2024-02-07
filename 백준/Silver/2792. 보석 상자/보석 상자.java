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
        int max =0;
        for (int i = 0; i < M; i++) {
            int next = Integer.parseInt(br.readLine());
            ls.add(next);
            max = Math.max(max,next);
        }

        int start =1;
        int end = max;
        int res = 0;

        while(start<=end){
            int mid = (start+end)/2;

            int people = 0;
            for (Integer i: ls) {
                if(i % mid == 0){
                    people += i/mid;
                }else{
                    people += i/mid + 1;
                }
            }

            if(people <= N){
                end = mid-1;
                res=mid;
            } else{
                start = mid+1;
            }
        }
        System.out.println(res);
    }
}
