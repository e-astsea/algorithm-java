import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        List<String> subStr = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            subStr.add(str.substring(i));
        }

        Collections.sort(subStr);

        for (int i = 0; i < subStr.size(); i++) {
            System.out.println(subStr.get(i));
        }
    }
}
