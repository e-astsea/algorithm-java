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
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<Integer> ls = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            ls.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(ls);
//        for (int i = 0; i < ls.size(); i++) {
            arr = new boolean[N];
            result = new int[N];
//            arr[i]=true;
//            result[0]=ls.get(i);
            dfs(ls,M,0);
//        }
    }
    static boolean[] arr;
    static int[] result;
    private static void dfs(List<Integer> ls, int max, int depth) {
        if(depth == max){
            for (int i = 0; i < max; i++) {
                System.out.print(result[i]+" ");
            }
            System.out.println("");
            return;
        }
        for (int i = 0; i < ls.size(); i++) {
            result[depth] = ls.get(i);
            if(arr[i]){
                continue;
            }
            arr[i]=true;
            dfs(ls,max,depth+1);
            arr[i]=false;
        }
    }
}
