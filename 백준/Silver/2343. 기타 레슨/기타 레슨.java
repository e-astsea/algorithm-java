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
        int start =0;
        int end = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int next = Integer.parseInt(st.nextToken());
            ls.add(next);
            end+=next;
            start=Math.max(start,next);
        }



        while(start<=end){
            int mid = (start+end)/2;

            int sum=0;
            int count=0;
            for (int i = 0; i < N; i++) {
                if (sum + ls.get(i) > mid) {
                    sum = 0;
                    count++;
                }
                sum += ls.get(i);
            }

            if(sum != 0) count++;


            if(count > M){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        System.out.println(start);
    }
}
