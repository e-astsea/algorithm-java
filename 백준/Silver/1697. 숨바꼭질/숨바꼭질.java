import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int[] arr=new int[200002];
    static int[] check = new int[200002];
    static int K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str=br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        bfs(N);
    }
    static void bfs(int x){
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        check[x]=1;
        if(x==K){
            System.out.println("0");
            return;
        }
        while(!q.isEmpty()) {
            int v = q.remove();
            if(arr[K]!=0){
                System.out.println(arr[K]);
                break;
            }
            for (int i = 0; i < 3; i++) {
                int nx = v;
                switch (i) {
                    case 0:
                        nx -= 1;
                        break;
                    case 1:
                        nx += 1;
                        break;
                    case 2:
                        nx *= 2;
                        break;
                }
                if (nx>=0 && nx<=100000 &&check[nx] != 1 ) {
                    check[nx]=1;
                    arr[nx] = arr[v] + 1;
                    q.add(nx);
                }
            }
        }
    }
}