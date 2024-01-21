import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder sb = new StringBuilder();

        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i)=='X'){
                count++;
            }
            if(i==str.length()-1 || str.charAt(i)=='.'){
                if(count%2 == 1){
                    System.out.println("-1");
                    return;
                } else{
                    int A = count / 4;
                    int B = count % 4 / 2;
                    for (int j = 0; j < A; j++) {
                        sb.append("AAAA");
                    }
                    for (int j = 0; j < B; j++) {
                        sb.append("BB");
                    }
                }
                if(str.charAt(i)=='.') {
                    sb.append(".");
                }
                count = 0;
            }
        }
        System.out.println(sb.toString());
    }
}
