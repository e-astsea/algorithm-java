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
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer> ls = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            ls.add(Integer.parseInt(br.readLine()));
        }

        ls.sort(Collections.reverseOrder());

        int answer = 0;
        int price = 0;

        for (int i = 0; i < M; i++) {
            if(i==N){
                break;
            }
            int tmp = ls.get(i)*(i+1);
            
            if(answer < tmp){
                answer = tmp;
                price = ls.get(i);
            }
        }

        System.out.println(price+" "+answer);
    }
}
