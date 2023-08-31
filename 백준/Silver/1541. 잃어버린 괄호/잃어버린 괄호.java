import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split("-");

        int answer = 0;

        for (int i = 0; i < split.length; i++) {

            int tmp = 0;

            tmp += Arrays.stream(split[i].split("\\+"))
                    .map(Integer::parseInt)
                    .mapToInt(Integer::intValue)
                    .sum();

            if (i == 0) {
                answer += tmp;
            } else {
                answer -= tmp;
            }
        }

        System.out.println(answer);
    }
}
