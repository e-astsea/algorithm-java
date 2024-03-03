import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Character> chars = List.of('a','e','i','o','u');

        while(true){
            String str = br.readLine();
            if(str.equals("end")){
                break;
            }

            boolean aeiou = false;
            boolean moja = false;
            boolean connect = false;
            int moconnect = 0;
            int jaconnect = 0;
            char tmp=' ';
            for (int i = 0; i < str.length(); i++) {
                if(chars.contains(str.charAt(i))){
                    aeiou=true;
                }
                if(chars.contains(str.charAt(i))){
                    moconnect++;
                    jaconnect=0;
                } else{
                    jaconnect++;
                    moconnect=0;
                }
                if(jaconnect>=3 || moconnect>=3){
                    moja = true;
                }
                if(tmp==str.charAt(i) && tmp!='e'&& tmp!='o') {
                    connect = true;
                }
                tmp = str.charAt(i);
            }

            if(aeiou && !moja && !connect){
                System.out.println("<"+str+"> is acceptable.");
            }else{
                System.out.println("<"+str+"> is not acceptable.");
            }

        }
    }
}
