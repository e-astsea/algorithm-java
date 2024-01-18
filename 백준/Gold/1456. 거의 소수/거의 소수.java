import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static final int max= 10000001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        final long first = Long.parseLong(st.nextToken());
        final long second = Long.parseLong(st.nextToken());

        boolean[] arr = new boolean[max];
        arr[1]=true;
        List<Integer> prime = new ArrayList<>();
        for (int i = 2; i <= Math.sqrt(second); i++) {
            if (arr[i]) {
                continue;
            }else {
                prime.add(i);
            }
            for (int j = i + i; j < max; j = j + i) {
                arr[j] = true;
            }
        }

        int answer = 0;
        for (int i = 0; i < prime.size(); i++) {
            double now = prime.get(i);
            for (double j = now*now; j <= second; j*=now) {
                if (j > second) {
                    break;
                }
                if (j < first) {
                    continue;
                }
                answer++;
            }
        }
        System.out.println(answer);
    }
}
