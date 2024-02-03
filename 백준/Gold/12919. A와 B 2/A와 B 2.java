import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        String T = br.readLine();

        ab(S,T);
        if (check){
            System.out.println("1");
        } else{
            System.out.println("0");
        }
    }
    static boolean check = false;
    private static void ab(String s, String t) {
        if(s.length() == t.length()){
            if(s.equals(t)){
                check=true;
                return ;
            } else{
                return ;
            }
        }
        StringBuffer sb = new StringBuffer(t);

        if(t.charAt(t.length()-1)=='A'){
            ab(s,t.substring(0,t.length()-1));
        }
        if(sb.reverse().toString().charAt(t.length()-1)=='B'){
            ab(s,sb.toString().substring(0,t.length()-1));
        }
    }
}
