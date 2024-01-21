import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        final String str = br.readLine();

        int redCount = 1;
        boolean redFlag = false;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i)=='R'){
                if(!redFlag){
                    redCount++;
                }
                redFlag = true;
            } else{
                redFlag = false;
            }
        }

        int blueCount = 1;
        boolean blueFlag = false;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i)=='B'){
                if(!blueFlag){
                    blueCount++;
                }
                blueFlag = true;
            } else{
                blueFlag = false;
            }
        }
        System.out.println(Math.min(blueCount,redCount));
    }
}
