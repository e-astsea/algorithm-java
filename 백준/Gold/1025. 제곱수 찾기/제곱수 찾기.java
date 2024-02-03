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

        int[][] arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
            }
        }

        int answer = -1;
        for (int i = 0; i < N; i++) {//행
            for (int j = 0; j < M; j++) {//열

                for (int k = -N; k < N; k++) { //행 이동
                    for (int l = -M; l < M; l++) { //열 이동
                        
                        if(k==0&& l==0){
                            continue;
                        }
                        int x = i;
                        int y = j;
                        String str = "";
                        while((x>=0&& x<N)&& (y>=0 && y<M)){
                            str=str.concat(String.valueOf(arr[x][y]));
                            int num = Integer.parseInt(str);

                            int root = (int)Math.sqrt(num);
                            if( Math.pow(root, 2) == num )
                                answer = Math.max(answer, num);

                            x+=k;
                            y+=l;
                        }
                    }
                }
            }
        }

        System.out.println(answer);
    }
}
