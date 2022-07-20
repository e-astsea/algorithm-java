import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int N;
    static int M;
    static int V;
    static ArrayList<Integer>[] al;
    static int[] visit;
    static Queue<Integer> que = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        al = new ArrayList[1001];
        for(int a=0; a<=N; a++){
            al[a] = new ArrayList<Integer>();
        }

        for (int i = 0; i < M; i++){
            str = br.readLine();
            st= new StringTokenizer(str);
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            al[first].add(second);
            al[second].add(first);
        }
        for(int i=0; i<=N; i++) {
            Collections.sort(al[i]);
        }

        visit = new int[1001];
        System.out.print(V+" ");
        dfs(V);
        System.out.println("");
        visit = new int[1001];
        bfs(V);
    }
    static void dfs(int x){
        visit[x]=1;
        for(int j=0; j<al[x].size(); j++){
            int k = al[x].get(j);
            if(visit[k]!=1){
                System.out.print(k+" ");
                dfs(k);
            }
        }
    }

    static void bfs(int x){
        visit[x]=1;
        que.add(x);
        while(!que.isEmpty()) {
            int index = que.poll();
            System.out.print(index+" ");
            for (int i = 0; i < al[index].size(); i++) {
                int b = al[index].get(i);
                if(visit[b]!=1 ) {
                    visit[b]=1;
                    que.add(b);
                }
            }
        }
    }
}