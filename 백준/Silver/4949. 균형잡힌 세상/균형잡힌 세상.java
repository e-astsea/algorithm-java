import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        StringTokenizer st;

        while(true){
            final String str = br.readLine();
            final Deque<Character> q = new ArrayDeque<>();
            if(str.equals(".")){
                break;
            }
            for (int i = 0; i < str.length(); i++) {
                if(str.charAt(i) == '(' || str.charAt(i) == '['){
                    q.addLast(str.charAt(i));
                }
                if(str.charAt(i) == ')') {
                    if (q.size() > 0 && q.peekLast() == '('){
                        q.pollLast();
                    } else {
                        q.addLast(str.charAt(i));
                    }
                }
                if(str.charAt(i) == ']') {
                    if (q.size() > 0 && q.peekLast() == '['){
                        q.pollLast();
                    } else{
                        q.addLast(str.charAt(i));
                    }
                }
            }

            if(q.size() == 0){
                System.out.println("yes");
            } else{
                System.out.println("no");
            }
        }
    }
}
