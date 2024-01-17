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

        List<Integer> ls = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            ls.add(Integer.parseInt(st.nextToken()));
        }
        int X = Integer.parseInt(br.readLine());
        double result = 0;
        int count = 0;
        for (int i = 0; i < ls.size(); i++) {
            int num = gdc(X, ls.get(i));
            if(num == -1){
                result += ls.get(i);
                count++;
            }
        }
        System.out.println(result/count);
    }

    private static int gdc(int x, int next) {
        if(next==1){
            return -1;
        }
        if(x%next==0){
            return next;
        } else{
            return gdc(next, x%next);
        }
    }
}
