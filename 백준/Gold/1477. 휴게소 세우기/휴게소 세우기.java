import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        List<Integer> ls = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            ls.add(Integer.parseInt(st.nextToken()));
        }
        ls.add(0);
        ls.add(L);
        Collections.sort(ls);

        int start =1;
        int end = L-1;
        while(start<=end){
            int mid = (start+end)/2;

            int sum = 0;
            for (int i = 0; i < ls.size()-1; i++) {
                sum += (ls.get(i+1)-ls.get(i)-1)/mid;
            }

            if(sum>M){
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        System.out.println(start);
    }
}
