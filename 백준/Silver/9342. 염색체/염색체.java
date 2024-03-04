import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String matchers = "[A-F]?A+F+C+[A-F]?$";
        for (int i = 0; i < N; i++) {
            final String str = br.readLine();
            if(str.matches(matchers)){
                System.out.println("Infected!");
            } else{
                System.out.println("Good");
            }
        }
    }
}
