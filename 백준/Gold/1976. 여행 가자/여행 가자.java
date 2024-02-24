import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        arr = new int[N+1];
        for (int i = 0; i <= N; i++) {
            arr[i] = i;
        }

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                if(Integer.parseInt(st.nextToken())==1){
                    union(i,j);
                }
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = find(Integer.parseInt(st.nextToken()));
        for (int i = 0; i < M-1; i++) {
            int nx = Integer.parseInt(st.nextToken());
            if(start!=find(nx)){
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    private static void union(int a, int b) {
        int na = find(a);
        int nb = find(b);

        arr[na]=nb;
    }

    private static int find(int a) {
        if(arr[a]==a){
            return a;
        } else{
            return arr[a]=find(arr[a]);
        }
    }
}
