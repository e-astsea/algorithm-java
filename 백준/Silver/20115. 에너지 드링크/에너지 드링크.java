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

        List<Integer> ls = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            ls.add(Integer.parseInt(st.nextToken()  ));
        }
        Collections.sort(ls,Collections.reverseOrder());

        double result = ls.get(0);
        for (int i = 1; i <ls.size(); i++) {
            result += (double)ls.get(i)/2;
        }
        System.out.println(result);
    }
}
