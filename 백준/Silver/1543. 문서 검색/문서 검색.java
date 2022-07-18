import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String test = br.readLine();
        int cnt =0;
        int icnt=0;
        for(int i=0; i<str.length(); i++){
            icnt=i;
            for(int j=0; j<test.length(); j++){
                if(i==(str.length())){
                    break;
                }
                if(str.charAt(i) == test.charAt(j)){
                    if(i<str.length())
                        i++;
                    if(j==test.length()-1){
                        i--;
                        cnt++;
                        break;
                    }
                }
                else {
                    i=icnt;
                    break;
                }
            }
        }
        System.out.println(cnt);

    }

}