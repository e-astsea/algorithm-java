import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> ls = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            ls.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(ls,Collections.reverseOrder());

        long result = 0;
        for (int i = 0; i < ls.size(); i++) {
            long pay = ls.get(i);
            if(pay-i<0){
                continue;
            }
            result += pay - (i);
        }
        System.out.println(result);
    }
}
