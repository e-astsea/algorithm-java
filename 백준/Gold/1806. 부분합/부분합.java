import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            list.add(Integer.parseInt(st.nextToken()));
        }

        int start = 0;
        int end = 0;
        int sum = 0;
        int shortestLength = Integer.MAX_VALUE;
        while(true){
            if(sum >= M){
                sum -= list.get(start);
                shortestLength = Math.min(shortestLength,end - start);
                start++;
            }
            else if(end == N){
                break;
            }
            else {
                sum += list.get(end);
                end++;
            }
        }
        if(shortestLength == Integer.MAX_VALUE){
            System.out.println(0);
        }
        else{
            System.out.println(shortestLength);
        }
    }
}
