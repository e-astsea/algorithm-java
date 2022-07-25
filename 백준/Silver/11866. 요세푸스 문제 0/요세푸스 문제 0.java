import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;



public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Queue<Integer> que = new LinkedList<>();
        for(int i=1; i<=N; i++){
            que.add(i);
        }
        int tmp=0;
        int count=0;
        while(!que.isEmpty()){
            if(count==0)
                System.out.print("<");
            for(int i=0; i<K-1; i++){
                tmp = que.remove();
                que.add(tmp);
            }
            tmp = que.remove();
            System.out.print(tmp);
            if(count<N-1)
                System.out.print(", ");
            else if(count == N-1)
                System.out.print(">");
            count++;
        }
    }
}