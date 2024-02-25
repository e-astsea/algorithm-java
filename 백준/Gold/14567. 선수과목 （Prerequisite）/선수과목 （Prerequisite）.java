import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Pair{
        int num;
        int when;

        public Pair(int num, int when) {
            this.num = num;
            this.when = when;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N+1];
        List<List<Integer>> ls = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            ls.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            ls.get(second).add(first);
        }

        Queue<Pair> q = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            if(ls.get(i).size()==0){
                q.add(new Pair(i,1));
                arr[i]=-1;
            }
        }

        int[] result = new int[N+1];
        while(!q.isEmpty()){
            Pair now = q.poll();
            result[now.num]=now.when;

            for (int i = 1; i <= N; i++) {
                ls.get(i).remove((Object)now.num);
                if(arr[i]!=-1 && ls.get(i).size()==0){
                    q.add(new Pair(i,now.when+1));
                    arr[i]=-1;
                }
            }
        }

        for (int i = 1; i < result.length; i++) {
            System.out.print(result[i]+" ");
        }
    }
}
