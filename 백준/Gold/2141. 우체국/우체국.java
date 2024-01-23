import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class Pair{
        int index;
        int value;

        public Pair(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Pair> ls = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            ls.add(new Pair(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }
        Collections.sort(ls, ((o1, o2) -> o1.index>o2.index ? 1:-1));

        int start = 0;
        int end = ls.size()-1;
        long leftResult = ls.get(0).value;
        long rightResult = ls.get(end).value;

        while(start<end){
            if(leftResult<rightResult){
                leftResult += ls.get(++start).value;
            } else if(rightResult<leftResult){
                rightResult += ls.get(--end).value;
            } else{
                leftResult += ls.get(++start).value;
                rightResult += ls.get(--end).value;
            }
        }

        System.out.println(ls.get(end).index);
    }
}
