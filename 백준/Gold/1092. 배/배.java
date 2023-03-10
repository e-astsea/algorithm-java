import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        List<Integer> crane = new ArrayList<>();
        for(int i=0; i<N; i++){
            crane.add(Integer.parseInt(st.nextToken()));
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        List<Integer> box = new ArrayList<>();
        for(int i=0; i<M; i++){
            box.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(crane,Collections.reverseOrder());
        Collections.sort(box,Collections.reverseOrder());

        if(crane.get(0)<box.get(0)){
            System.out.println(-1);
            return;
        }

        int time=0;
        while(!box.isEmpty()){
            int cur = 0;
            for(int i=0; i<crane.size(); i++){
                if(cur == box.size())
                    break;
                else if(crane.get(i) >= box.get(cur)) {
                    box.remove(cur);
                }
                else {
                    cur++;
                    i--;
                }
            }
            time++;
        }

        System.out.println(time);
    }
}
