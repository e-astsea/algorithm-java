import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final String str = br.readLine();

        Deque<String> deque = new ArrayDeque<>();
        int result = 0;
        boolean check = false;

        for (int i = 0; i < str.length(); i++) {
            final char c = str.charAt(i);
            if (c == '(' || c == '[') {
                deque.addLast(String.valueOf(str.charAt(i)));
            } else if (c == ')') {
                if(deque.isEmpty()||deque.peekLast()==null){
                    break;
                }
                if (deque.peekLast().equals("(")) {
                    deque.pollLast();
                    deque.addLast("2");
                } else {
                    try {
                        int num = Integer.parseInt(deque.peekLast());
                    } catch (NumberFormatException nfe) {
                        check = true;
                        break;
                    }
                    int tmp = 0;
                    while (!deque.peekLast().equals("(")) {
                        try {
                            int num = Integer.parseInt(deque.peekLast());
                        } catch (NumberFormatException nfe) {
                            check = true;
                            break;
                        }
                        final int num = Integer.parseInt(deque.pollLast().toString());
                        tmp += num;
                        if(deque.isEmpty()){
                            break;
                        }
                    }
                    if(deque.isEmpty()){
                        break;
                    }
                    deque.pollLast();
                    tmp *= 2;
                    deque.addLast(String.valueOf(tmp));
                }
            } else if (c == ']') {
                if(deque.isEmpty()||deque.peekLast()==null){
                    break;
                }
                if (deque.peekLast().equals("[")) {
                    deque.pollLast();
                    deque.addLast("3");
                } else {
                    try {
                        int num = Integer.parseInt(deque.peekLast());
                    } catch (NumberFormatException nfe) {
                        check = true;
                        break;
                    }
                    int tmp = 0;
                    while (!deque.peekLast().equals("[")) {
                        try {
                            int num = Integer.parseInt(deque.peekLast());
                        } catch (NumberFormatException nfe) {
                            check = true;
                            break;
                        }
                        final int num = Integer.parseInt(deque.pollLast().toString());
                        tmp += num;
                        if(deque.isEmpty()){
                            break;
                        }
                    }
                    if(deque.isEmpty()){
                        break;
                    }
                    deque.pollLast();
                    tmp *= 3;
                    deque.addLast(String.valueOf(tmp));
                }
            }
        }
        if (!check) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                try {
                    result += Integer.parseInt(deque.pollLast().toString());
                } catch (NumberFormatException nfe) {
                    result=0;
                    break;
                }
            }
        }
        System.out.println(result);
    }
}
