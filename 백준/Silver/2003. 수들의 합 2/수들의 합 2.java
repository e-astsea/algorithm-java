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

        int firstIndex = 0;
        int count = 0;
        while(firstIndex<list.size()){
            int sum = 0;
            for(int i = firstIndex; i<list.size(); i++){
                sum += list.get(i);
                if(sum>M){
                    break;
                }
                else if(sum==M){
                    count++;
                    break;
                }
            }
            firstIndex++;
        }
        System.out.println(count);
    }
}
