import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final String str = br.readLine();
        final String[] split = str.split(":");

        final String str2 = br.readLine();
        final String[] split2 = str2.split(":");

        int[] result = new int[3];
        for (int i = 0; i < 3; i++) {
            result[i]=Integer.parseInt(split2[i]) -Integer.parseInt(split[i]);
        }

        if(str.equals(str2)){
            System.out.println("24:00:00");
        } else {
            if (result[2] < 0) {
                result[2] += 60;
                result[1] -= 1;
            }
            if (result[1] < 0) {
                result[1] += 60;
                result[0] -= 1;
            }
            if (result[0] < 0) {
                result[0] += 24;
            }
            System.out.format("%02d:%02d:%02d",result[0],result[1],result[2]);
        }
    }
}
