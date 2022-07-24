import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class pair{
    int edge;
    int length;
    pair(int edge, int length){
        this.edge = edge;
        this.length = length;
    }
}
public class Main {
    static int []checked;
    static ArrayList<pair>[] arr;
    static int []dis;
    static Queue<Integer> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st;
        int N = Integer.parseInt(str);
        arr= new ArrayList[N+1];
        for(int i=1; i<=N; i++)
            arr[i] = new ArrayList<pair>();

        for(int i=0; i<N; i++){
            str = br.readLine();
            st = new StringTokenizer(str);
            int V = Integer.parseInt(st.nextToken());
            while(true){
                int first = Integer.parseInt(st.nextToken());
                if(first ==-1) {
                    break;
                }
                int second = Integer.parseInt(st.nextToken());
                arr[V].add(new pair(first,second));
            }
        }



            checked = new int[N+1];
            dis = new int[N+1];
            dfs(2);

            checked = new int[N+1];
            dis = new int[N+1];
            dfs(max);

            Arrays.sort(dis);
            System.out.println(dis[N]);
    }
    static int index=0;
    static int max=0;
    static int result=0;
    static void dfs(int start){
        checked[start]=1;
        for(int i=0; i<arr[start].size(); i++) {
            pair p = arr[start].get(i);
            if(checked[p.edge]!=1) {
                dis[p.edge]=dis[start]+p.length;
                if(dis[max]<dis[p.edge]){
                    max = p.edge;
                }
                index = p.edge;
                checked[p.edge]=1;
                dfs(p.edge);
            }

        }
        checked[start]=0;
    }

}