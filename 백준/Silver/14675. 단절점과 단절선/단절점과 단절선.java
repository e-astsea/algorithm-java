import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<List<Integer>> ls = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            ls.add(new ArrayList<>());
        }

        for (int i = 0; i < N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            ls.get(first).add(second);
            ls.get(second).add(first);
        }

        int Q = Integer.parseInt(br.readLine());
        for (int i = 0; i < Q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            if(first == 1){
                if(ls.get(second).size()>1){
                    System.out.println("yes");
                } else{
                    System.out.println("no");
                }
            } else{
                System.out.println("yes");
            }
        }
    }
}
