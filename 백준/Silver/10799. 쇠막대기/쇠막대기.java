import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    // ()가 나타나면 큐에존재하는 (의 개수만큼 수 증가
    // () 가 아닌 )가 나타나면 큐에 존재하는 ( 만큼 증가
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final String str = br.readLine();
        final Queue<Character> que = new LinkedList<>();
        int count = 0;
        Boolean lazer = false;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c == '(') {
                que.add(c);
            }
            if (c == ')' && str.charAt(i-1) == '(') {
                count += (que.size()-1);
                que.poll();
            } else if (c == ')') {
                count += 1;
                que.poll();
            }
        }
        System.out.println(count);
    }
}
