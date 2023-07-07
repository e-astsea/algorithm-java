import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Pair {
    int x;
    int y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static int N;
    static int M;
    static int[][] result = new int[N][M];
    static int[][] arr = new int[N][M];

    static List<Pair> ls = new ArrayList<>();
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        result = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(arr[i][j] !=0 && arr[i][j] != 6){
                    ls.add(new Pair(i,j));
                }
                result[i][j] = arr[i][j];
            }
        }
        dfs(0);
        System.out.println(answer);
    }

    private static void dfs(int depth) {
//        for (int a = 0; a < N; a++) {
//            for (int j = 0; j < M; j++) {
//                System.out.print(result[a][j]+" ");
//            }
//            System.out.println();
//        }
//        System.out.println("");
        if(depth == ls.size()){
            answer = Math.min(answer, calculate());
            return;
        }

        Pair pair = ls.get(depth);
        int x = pair.x;
        int y = pair.y;

        if(arr[x][y] == 1){
            for (int i = 0; i < 4; i++) {
                int[][] tmp = new int[N][M];
                reset(tmp,result);
                first(pair,i);
                dfs(depth+1);
                reset(result, tmp);
            }
        } else if(arr[x][y] == 2){
            for (int i = 0; i <2 ; i++) {
                int[][] tmp = new int[N][M];
                reset(tmp,result);
                second(pair,i);
                dfs(depth+1);
                reset(result, tmp);
            }
        }else if(arr[x][y] == 3){
            for (int i = 0; i < 4; i++) {
                int[][] tmp = new int[N][M];
                reset(tmp,result);
                third(pair,i);
                dfs(depth+1);
                reset(result, tmp);
            }
        }else if(arr[x][y] == 4){
            for (int i = 0; i < 4; i++) {
                int[][] tmp = new int[N][M];
                reset(tmp,result);
                fourth(pair,i);
                dfs(depth+1);
                reset(result, tmp);
            }
        }else if(arr[x][y] == 5){
            int[][] tmp = new int[N][M];
            reset(tmp,result);
            fifth(pair);
            dfs(depth+1);
            reset(result, tmp);
        }
    }

    private static int calculate() {
        int num =0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(result[i][j] == 0){
                    num++;
                }
            }
        }
        return num;
    }

    private static void reset(int[][] first, int[][] second) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                first[i][j] = second[i][j];
            }
        }
    }

    private static void first(Pair pair,int point) {
        if(point == 0){
            right(pair);
        } else if(point == 1){
            down(pair);
        }else if(point == 2){
            left(pair);
        }else if(point == 3){
            up(pair);
        }
    }

    private static void second(Pair pair, int point) {
        if(point == 0){
            right(pair);
            left(pair);
        } else if(point == 1){
            up(pair);
            down(pair);
        }
    }

    private static void third(Pair pair, int point) {
        if(point == 0){
            up(pair);
            right(pair);
        } else if(point == 1){
            right(pair);
            down(pair);
        }else if(point == 2){
            down(pair);
            left(pair);
        }else if(point == 3){
            left(pair);
            up(pair);
        }
    }
    private static void fourth(Pair pair, int point) {
        if(point == 0){
            up(pair);
            right(pair);
            left(pair);
        } else if(point == 1){
            right(pair);
            down(pair);
            up(pair);
        }else if(point == 2){
            down(pair);
            left(pair);
            right(pair);
        }else if(point == 3){
            left(pair);
            up(pair);
            down(pair);
        }
    }

    private static void fifth(Pair pair) {
        up(pair);
        down(pair);
        left(pair);
        right(pair);
    }

    private static void up(Pair pair) {
        for (int i = pair.x-1; i >= 0; i--) {
            if (checkWall(i, pair.y)) break;
            if (checkCctv(i, pair.y)) continue;
            result[i][pair.y] = -1;
        }
    }


    private static void left(Pair pair) {
        for (int i = pair.y-1; i >= 0; i--) {
            if (checkWall(pair.x, i)) break;
            if (checkCctv(pair.x,i)) continue;

            result[pair.x][i] = -1;
        }
    }

    private static void down(Pair pair) {
        for (int i = pair.x+1; i < N; i++) {
            if (checkWall(i, pair.y)) break;
            if (checkCctv(i,pair.y)) continue;

            result[i][pair.y] = -1;
        }
    }

    private static void right(Pair pair) {
        for (int i = pair.y+1; i < M; i++) {
            if (checkWall(pair.x, i)) break;
            if (checkCctv(pair.x,i)) continue;

            result[pair.x][i] = -1;
        }
    }

    private static boolean checkWall(int x, int y) {
        if(result[x][y] == 6){
            return true;
        }
        return false;
    }


    private static boolean checkCctv(int x, int y) {
        if(result[x][y] != 0){
            return true;
        }
        return false;
    }
}


