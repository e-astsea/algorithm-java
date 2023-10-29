import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {
            final String str = br.readLine();
            System.out.println(find(str));
        }
    }

    private static int find(String str) {
        final StringBuilder sb = new StringBuilder(str);
        if(str.equals(sb.reverse().toString())){
            return 0;
        }
        int start = 0;
        int end = str.length()-1;
        int check = 0;
        while(start<=end){
            if(str.charAt(start) != str.charAt(end)){
                if(check++ >1){
                    return 2;
                }
                StringBuilder deleteEnd = new StringBuilder(str).deleteCharAt(end);
                StringBuilder deleteStart = new StringBuilder(str).deleteCharAt(start);
                if(deleteStart.toString().equals(deleteStart.reverse().toString()) || deleteEnd.toString().equals(deleteEnd.reverse().toString())){
                    return 1;
                }
            }
            start++;
            end--;
        }
        return 2;
    }
}
