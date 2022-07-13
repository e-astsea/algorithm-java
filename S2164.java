import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int N = Integer.parseInt(str);
        Queue<Integer> qe = new LinkedList<>();

        for(int i=1; i<=N; i++){
            qe.add(i);
        }
        while(qe.size()!=1){
            qe.remove();
            int a = qe.poll();
            qe.add(a);
        }
        System.out.println(qe.peek());

    }
}