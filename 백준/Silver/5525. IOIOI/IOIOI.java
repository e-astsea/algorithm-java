import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int N = Integer.parseInt(br.readLine());
        String p = "IOI";
        for (int i = 0; i < N-1; i++) {
            p = String.join("",p,"OI");
        }

        final int M = Integer.parseInt(br.readLine());
        final String S = br.readLine();
        int answer = 0;

        for (int i = 0; i <= M-p.length(); i++) {
            if(S.substring(i,i+p.length()).equals(p)){
                answer++;
            }
        }

        System.out.println(answer);
    }
}
