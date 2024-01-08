import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            q.add(i);
        }

        int count = 0;
        System.out.print("<");
        while(!q.isEmpty()){
            count++;
            if(count == K){
                System.out.print(q.poll());
                if (!q.isEmpty()){
                    System.out.print(", ");
                }
                count = 0;
                continue;
            }
            q.add(q.poll());
        }
        System.out.println(">");
    }
}
