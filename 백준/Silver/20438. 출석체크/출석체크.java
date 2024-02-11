import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] prefix = new int[5005];
        int[] sleep = new int[5005];
        int[] used = new int[5005];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= K; i++) {
            sleep[Integer.parseInt(st.nextToken())]=1;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= Q; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(sleep[num]==1) continue;

            for (int j = num; j <= N+2; j+=num) {
                if(sleep[j]==1){
                    continue;
                }
                used[j]=1;
            }
        }

        for (int i = 3; i <= N+2; i++) {
            prefix[i] = prefix[i-1];
            if(used[i]==0){
                prefix[i]++;
            }
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            System.out.println(prefix[second]-prefix[first-1]);
        }
    }
}
