import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final String str = br.readLine();
        int result = 0;

        for (int i = 0; i < str.length(); i++) {
            for (int count = 2; i + count <= str.length(); count += 2) {
                int firstCount = 0;
                int secondCount = 0;
                for (int j = i; j < i + count / 2; j++) {
                    firstCount += str.charAt(j) - '0';
                }
                for (int j = i + count / 2; j < i + count; j++) {
                    secondCount += str.charAt(j) - '0';
                }

                if (firstCount == secondCount) {
                    result = Math.max(result, count);
                }
            }
        }
        System.out.println(result);
    }
}
