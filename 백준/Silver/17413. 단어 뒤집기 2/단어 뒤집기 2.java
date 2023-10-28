import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final String s = br.readLine();
        boolean mode = false;
        List<Character> ch = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            final Character c = s.charAt(i);

            if(c == '<'){
                for (int j = ch.size()-1; j >=0; j--) {
                    System.out.print(ch.get(j));
                }
                ch.clear();
                mode = true;
            } else if( c =='>'){
                ch.add(c);
                for (int j = 0; j < ch.size(); j++) {
                    System.out.print(ch.get(j));
                }
                mode = false;
                ch.clear();
                continue;
            }


            if(!mode && c==' ' || i == s.length()-1){
                if(i != s.length()-1){
                    ch.add(0,c);
                } else{
                    ch.add(c);
                }
                for (int j = ch.size()-1; j >=0; j--) {
                    System.out.print(ch.get(j));
                }
                ch.clear();
                continue;
            }


            ch.add(c);


        }
    }
}
