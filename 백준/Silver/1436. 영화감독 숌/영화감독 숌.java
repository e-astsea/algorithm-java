import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int N = Integer.parseInt(str);
        int count=0;
        for(int j=666; ; j++){
            String strr=Integer.toString(j);
            int num=0;

            for(int i=0; i<strr.length();i++){

                if(strr.charAt(i) == '6'){
                    num++;
                }
                else{
                    num=0;
                }

                if(num>=3){
                    count++;
                    if(count==N){
                        System.out.println(j);
                        return;
                    }
                break;
                }
            }
        }
    }
}