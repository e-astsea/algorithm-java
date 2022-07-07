import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S10773 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Stack<Integer> stack = new Stack<>();

        String s = br.readLine();
        int N = Integer.parseInt(s);
        for(int i=0; i<N; i++) {
            s = br.readLine();
            if(Integer.parseInt(s)!=0)
                stack.push(Integer.parseInt(s));
            else
                stack.pop();
        }
        int result=0;
        while(!stack.isEmpty()){
            result +=stack.pop();
        }
        System.out.println(result);

    }

}