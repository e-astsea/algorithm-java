import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int M;
    static int N;
    static int[]checked;
    static ArrayList<Integer>[] al;
    static int[]arr;
    static Queue<Integer> que = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        N = Integer.parseInt(st.nextToken());
        al = new ArrayList[N+1];
        for(int i=0; i<=N;i++){
            al[i]=new ArrayList<Integer>();
        }

        for(int i=0; i<N-1; i++){
            str=br.readLine();
            st = new StringTokenizer(str);
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            al[first].add(second);
            al[second].add(first);
        }
        for(int i=0; i<=N; i++){
            Collections.sort(al[i]);
        }
            arr = new int[N+1];
            checked = new int[N+1];
            bfs(1);

            for(int i=2; i<=N; i++){
                System.out.println(arr[i]);
            }
    }

    static void bfs(int x){

        que.add(x);
        while(!que.isEmpty()) {
            int tmp = que.remove();
            for (int i = 0; i < al[tmp].size(); i++) {
                int ge = al[tmp].get(i);

                if(arr[ge]==0) {
                    arr[ge]=tmp;
                    que.add(ge);
                }
            }
        }

    }
}