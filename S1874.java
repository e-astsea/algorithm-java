import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S1874 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        String str = br.readLine();
        int strint = Integer.parseInt(str);
        int start=0;

        while(strint-->0){
            String num = br.readLine();
            int numint = Integer.parseInt(num);

            if (numint > start) {
                for(int i= start+1; i<=numint; i++) {
                    sb.append('+').append('\n');
                    stack.push(i);
                }
                start=numint;
            }
            else if(stack.peek()!= numint){
                System.out.println("NO");
                return;
            }

            stack.pop();
            sb.append('-').append('\n');
        }
        System.out.print(sb);
    }

}