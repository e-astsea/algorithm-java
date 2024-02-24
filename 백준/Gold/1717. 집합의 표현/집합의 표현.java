import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        root = new int[N+1];
        for (int i = 0; i <= N; i++) {
            root[i]=i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int flag = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(flag==0) {
                union(a, b);
            } else{
                if(find(a) == find(b)){
                    System.out.println("YES");
                } else{
                    System.out.println("NO");
                }
            }
        }
    }
    static int[] root;
    public static void union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);

        if(rootA!=rootB)
            root[rootA] = rootB;
    }

    public static int find(int x) {
        if(root[x] == x){
            return x;
        } else{
            return root[x]=find(root[x]);
        }
    }
}
