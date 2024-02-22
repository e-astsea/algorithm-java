import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(arr,0,0,N);

        System.out.println(white);
        System.out.println(blue);
    }
    static int blue=0;
    static int white=0;
    private static void dfs(int[][] arr,int x, int y, int size) {
        final int check = checkColor(arr, x, y, size);
        if(check!=0){
            if(check==1){
                blue++;
            } else{
                white++;
            }
            return;
        }

        int nsize = size/2;

        dfs(arr,x,y,nsize);
        dfs(arr,x,y+nsize,nsize);
        dfs(arr, x+nsize, y, nsize);
        dfs(arr,x+nsize,y+nsize,nsize);
    }

    private static int checkColor(int[][] arr, int x, int y, int size) {
        int blue = 0;
        int white = 0;
        for (int i = x; i < x+size; i++) {
            for (int j = y; j < y+size; j++) {
                if(arr[i][j] == 1){
                    blue++;
                } else {
                    white++;
                }
            }
        }
        if(size*size==blue){
            return 1;
        } else if (size*size ==white) {
            return 2;
        } else{
            return 0;
        }
    }
}
