import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int k;
    static int x;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        List<List<Integer>> list = new ArrayList<>();
        int[] result = new int[n+1];

        for (int i = 0; i < n+1; i++) {
            list.add(new ArrayList<>());
            result[i]=-1;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            list.get(first).add(second);
        }

        Queue<Integer> que = new ArrayDeque<>();
        que.add(x);
        result[x] = 0;
        while(!que.isEmpty()){
            int now = que.poll();
            for (int i = 0; i < list.get(now).size(); i++) {
                int next = list.get(now).get(i);
                if(result[next] == -1){
                    result[next] = result[now] +1;
                    que.add(next);
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n+1; i++) {
            if(result[i] == k){
                res.add(i);
            }
        }

        if(res.size()==0){
            System.out.println("-1");
        } else {
            Collections.sort(res);
            for (int i = 0; i < res.size(); i++) {
                System.out.println(res.get(i));
            }
        }
    }
}
