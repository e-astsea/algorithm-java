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
        int K = Integer.parseInt(st.nextToken());

        List<Integer> ls = new ArrayList<>();
        List<Integer> difference = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            ls.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(ls);
        for (int i = 0; i < N-1; i++) {
            difference.add(Math.abs(ls.get(i)-ls.get(i+1)));
        }
        Collections.sort(difference);

        int result = 0;
        for (int i = 0; i < N-K; i++) {
            result+=difference.get(i);
        }
        System.out.println(result);
    }
}

