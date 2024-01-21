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
        int N = Integer.parseInt(br.readLine());

        List<Long> ls = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            ls.add(Long.parseLong(st.nextToken()));
        }
        Collections.sort(ls);

        if(ls.size()%2==0){
            long result = 0;
            int start = 0;
            int end = ls.size()-1;
            while(start<end){
                result = Math.max(result,(ls.get(start) + ls.get(end)));
                start++;
                end--;
            }
            System.out.println(result);
        } else{
            long result = ls.get(ls.size()-1);
            int start = 0;
            int end = ls.size()-2;
            while(start<end){
                result = Math.max(result,(ls.get(start) + ls.get(end)));
                start++;
                end--;
            }
            System.out.println(result);
        }
    }
}
