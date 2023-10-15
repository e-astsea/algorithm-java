import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final String str = br.readLine();
        final Deque<Character> que = new ArrayDeque<>();
        for (int i = 0; i < str.length(); i++) {
            final char ch = str.charAt(i);

            if (ch == '(') {
                que.add(ch);
            } else if (ch == ')') {
                Character c;
                while (true) {
                    Character polled = que.pollLast();
                    if (polled == '(') {
                        break;
                    }
                    System.out.print(polled);
                }
            } else if (ch == '*' || ch == '/' || ch == '+' || ch == '-') {
                while (!que.isEmpty()) {
                    Character polled = que.peekLast();
                    if (polled == '(') {
                        break;
                    }
                    if (ch == '+' || ch == '-') {
                        if (polled == '*' || polled =='/'|| polled == '+' || polled =='-'){
                            System.out.print(que.pollLast());
                        }else{
                            break;
                        }
                    } else if (ch == '*' || ch == '/') {
                        if (polled == '*' || polled =='/'){
                            System.out.print(que.pollLast());
                        }else{
                            break;
                        }
                    }
                }
                que.add(ch);
            } else {
                System.out.print(ch);
            }
        }
        while (!que.isEmpty()) {
            System.out.print(que.pollLast());
        }
    }
}
