import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        String str = br.readLine();

        Double[] arr = new Double[num];
        for (int i = 0; i < num; i++) {
            arr[i] = Double.parseDouble(br.readLine());
        }

        Stack<Double> q = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i)>=65 && str.charAt(i)<=90) {
                q.add(arr[str.charAt(i)-65]);
            } else{
                final Double first = q.pop();
                final Double second = q.pop();

                if (str.charAt(i) == '*') {
                    q.add(second*first);
                } else if (str.charAt(i) == '+') {
                    q.add(second+first);
                } else if (str.charAt(i) == '/') {
                    q.add(second/first);
                } else if (str.charAt(i) == '-') {
                    q.add(second-first);
                }
            }
        }

        System.out.printf("%.2f",q.pop());
    }
}
