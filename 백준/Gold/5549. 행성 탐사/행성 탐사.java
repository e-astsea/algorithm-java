import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int K = Integer.parseInt(br.readLine());

        Character[][] arr = new Character[M+1][N+1];
        for (int i = 1; i <= M; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j+1]=str.charAt(j);
            }
        }

        int[][][] sum = new int[M+1][N+1][3];
        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                if(arr[i][j]=='J') {
                    sum[i][j][0] = sum[i - 1][j][0] + sum[i][j - 1][0]- sum[i-1][j-1][0]+1;
                    sum[i][j][1] = sum[i - 1][j][1] + sum[i][j - 1][1]- sum[i-1][j-1][1];
                    sum[i][j][2] = sum[i - 1][j][2] + sum[i][j - 1][2] - sum[i-1][j-1][2];
                } else if (arr[i][j]=='O') {
                    sum[i][j][0] = sum[i - 1][j][0] + sum[i][j - 1][0] - sum[i-1][j-1][0];
                    sum[i][j][1] = sum[i - 1][j][1] + sum[i][j - 1][1]+1 - sum[i-1][j-1][1];
                    sum[i][j][2] = sum[i - 1][j][2] + sum[i][j - 1][2] - sum[i-1][j-1][2];
                } else {
                    sum[i][j][0] = sum[i - 1][j][0] + sum[i][j - 1][0] - sum[i-1][j-1][0];
                    sum[i][j][1] = sum[i - 1][j][1] + sum[i][j - 1][1] - sum[i-1][j-1][1];
                    sum[i][j][2] = sum[i - 1][j][2] + sum[i][j - 1][2]+1 - sum[i-1][j-1][2];
                }
            }
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            sb.append(sum[c][d][0]-sum[c][b-1][0]-sum[a-1][d][0]+sum[a-1][b-1][0]+" ");
            sb.append(sum[c][d][1]-sum[c][b-1][1]-sum[a-1][d][1]+sum[a-1][b-1][1]+" ");
            sb.append(sum[c][d][2]-sum[c][b-1][2]-sum[a-1][d][2]+sum[a-1][b-1][2]+" ");
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
