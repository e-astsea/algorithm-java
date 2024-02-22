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
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
            }
        }
        dfs(arr,0,0,N,0);
    }

    private static void dfs(int[][] arr,int x, int y, int size,int depth) {
        int num = checkColor(arr, x, y, size);
        if(num==1 ||num==0){
            System.out.print(num);
            return;
        } else{
            System.out.print("(");
        }

        int nsize = size/2;

        dfs(arr,x,y,nsize,depth+1);
        dfs(arr,x,y+nsize,nsize,depth+1);
        dfs(arr, x+nsize, y, nsize,depth+1);
        dfs(arr,x+nsize,y+nsize,nsize,depth+1);
                    System.out.print(")");

    }

    private static int checkColor(int[][] arr, int x, int y, int size) {
        int white = 0;
        int black = 0;
        for (int i = x; i < x+size; i++) {
            for (int j = y; j < y+size; j++) {
                if(arr[i][j] == 1){
                    white++;
                } else {
                    black++;
                }
            }
        }
        if(size*size==white){
            return 1;
        } else if (size*size ==black) {
            return 0;
        } else{
            return 3;
        }
    }
}
