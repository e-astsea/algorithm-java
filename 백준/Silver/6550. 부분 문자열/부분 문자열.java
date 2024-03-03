import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str;
        while((str = br.readLine()) != null){
            StringTokenizer st = new StringTokenizer(str);
            String str1 = st.nextToken();
            String str2 = st.nextToken();

            int str1Index =0;
            for (int i = 0; i < str2.length(); i++) {
                if(str2.charAt(i) == str1.charAt(str1Index)){
                    str1Index++;
                } else{
                    continue;
                }
                if(str1Index==str1.length()){
                    break;
                }
            }
            if(str1Index==str1.length()){
                System.out.println("Yes");
            } else{
                System.out.println("No");
            }
        }
    }
}
