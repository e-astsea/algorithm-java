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

        final int num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {
            final StringTokenizer st = new StringTokenizer(br.readLine());
            final String first = st.nextToken();
            List<Character> f = new ArrayList<>();
            for (int j = 0; j < first.length(); j++) {
                f.add(first.charAt(j));
            }
            final String second = st.nextToken();

            List<Character> s = new ArrayList<>();
            for (int j = 0; j < second.length(); j++) {
                s.add(second.charAt(j));
            }

            Collections.sort(f);
            Collections.sort(s);

            if(f.size() != s.size()){
                System.out.println(first +" & "+second+" are NOT anagrams.");
                continue;
            }

            for (int j = 0; j < s.size(); j++) {
                if(f.get(j) != s.get(j)){
                    System.out.println(first +" & "+second+" are NOT anagrams.");
                    break;
                }
                if(j==s.size()-1){
                    System.out.println(first +" & "+second+" are anagrams.");
                }
            }
        }
    }
}
