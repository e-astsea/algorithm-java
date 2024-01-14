import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static Map<Integer,Boolean> map = new HashMap<>();
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        List<List<Integer>> ls = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            ls.add(new ArrayList<>());
        }

        for (int i = 1; i <= N; i++) {
                ls.get(i / 2).add(i);
        }

        for (int i = 0; i < Q; i++) {
            final int num = Integer.parseInt(br.readLine());
            answer = 0;
            if(dfs(ls,num)){
                map.put(num,true);
            }
        }
    }

    private static boolean dfs(List<List<Integer>> ls, int target) {
        if(target == 1 && answer == 0){
            System.out.println("0");
            return true;
        } else if (target == 1 && answer != 0) {
            System.out.println(answer);
            return false;
        }
        if(map.containsKey(target)){
            answer = target;
        }
        return dfs(ls,target/2);
    }
}
