
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Stack<Integer> stack = new Stack<>();

        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String str = st.nextToken();
            if(str.equals("push")) {
                int num = Integer.parseInt(st.nextToken());
                stack.push(num);
            }
            else if(str.equals("top")) {
                if(stack.isEmpty()) {
                    System.out.println("-1");
                }
                else
                    System.out.println(stack.peek());
            }
            else if(str.equals("size")) {
                if(!stack.isEmpty())
                    System.out.println(stack.size());
                else
                    System.out.println("0");
            }
            else if(str.equals("empty")) {
                if(stack.isEmpty())
                    System.out.println("1");
                else
                    System.out.println("0");
            }
            else if(str.equals("pop")) {
                if(stack.isEmpty())
                    System.out.println("-1");
                else if(!stack.isEmpty()) {
                    int a = stack.pop();
                    System.out.println(a);
                }
            }

        }

    }

}