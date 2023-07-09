import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        boolean check=false;
        for (int i = 0; i < str.length(); i++) {
            int last = str.length()-1-i;
            if(i>=last){
                check=true;
                break;
            }
            if(str.charAt(i) == str.charAt(last)){
                continue;
            }
            check = false;
            break;
        }

        if (check){
            System.out.println("1");
        } else {
            System.out.println("0");
        }
    }
}
