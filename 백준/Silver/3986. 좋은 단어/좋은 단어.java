import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        int count = 0;
        for (int i = 0; i < num; i++) {
            Stack<Character> stack = new Stack<>();
            final String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                if(!stack.isEmpty()){
                    if(stack.peek() == str.charAt(j)){
                        stack.pop();
                    } else{
                        stack.push(str.charAt(j));
                    }
                } else {
                    stack.push(str.charAt(j));
                }
            }
            if(stack.isEmpty()){
                count++;
            }
        }
        System.out.println(count);

    }
}
