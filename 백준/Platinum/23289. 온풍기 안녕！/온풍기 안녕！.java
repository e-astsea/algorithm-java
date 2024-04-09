import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int[][] temp;

    static List<Pair> wall;
    static int R;
    static int C;
    static int K;

    static class Pair{
        int x;
        int y;
        int value;

        public Pair(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int chocolate = 0;
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[R+1][C+1];
        wall = new ArrayList<>();
        temp = new int[R+1][C+1];

        for (int i = 1; i <= R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int W = Integer.parseInt(br.readLine());
        for (int i = 0; i < W; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            wall.add(new Pair(x,y,t));
        }

        while(checkTemp()){
            //온풍기 바람 슝
            heat();
            //온도 조절
            changeTemp();
            // 온도 가장 바깥은 1이상 1감소
            decreaseTemp();   
            //초콜릿 먹기
            chocolate++;
            if(chocolate>=101){
                break;
            }
        }
        System.out.println(chocolate);
    }

    private static void changeTemp() {
        int[][] diff = new int[R+1][C+1];
        boolean[][] checked = new boolean[R+1][C+1];

        //상 우 하 좌
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};

        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                for (int k = 0; k < 4; k++) {
                    int nx = i+dx[k];
                    int ny = j+dy[k];

                    if(!checkInMap(nx, ny)){
                        continue;
                    }
                    boolean check = false;
                    //벽도 체크해야하고
                    if(k==0){
                        for (int a = 0; a < wall.size(); a++) {
                            final Pair pair = wall.get(a);
                            if(pair.x == nx+1 && pair.y == ny && pair.value == 0){
                                check = true;
                            }
                        }
                    } else if(k==1){
                        for (int a = 0; a < wall.size(); a++) {
                            final Pair pair = wall.get(a);
                            if(pair.x == nx && pair.y == ny-1 && pair.value == 1){
                                check = true;
                            }
                        }
                    } else if(k==2){
                        for (int a = 0; a < wall.size(); a++) {
                            final Pair pair = wall.get(a);
                            if(pair.x == nx && pair.y == ny && pair.value == 0){
                                check = true;
                            }
                        }
                    } else if(k==3){
                        for (int a = 0; a < wall.size(); a++) {
                            final Pair pair = wall.get(a);
                            if(pair.x == nx && pair.y == ny && pair.value == 1){
                                check = true;
                            }
                        }
                    }
                    if(check || checked[nx][ny]){
                        continue;
                    }
                    checked[i][j]=true;
                    if(temp[i][j]<=temp[nx][ny]){
                        diff[nx][ny]-=(temp[nx][ny]-temp[i][j])/4;
                        diff[i][j]+=(temp[nx][ny]-temp[i][j])/4;
                    } else{
                        diff[nx][ny]+=(temp[i][j]-temp[nx][ny])/4;
                        diff[i][j]-=(temp[i][j]-temp[nx][ny])/4;
                    }
                }
            }
        }

        for (int i = 1; i <=R ; i++) {
            for (int j = 1; j <= C; j++) {
                temp[i][j]+=diff[i][j];
                if(temp[i][j]<0){
                    temp[i][j]=0;
                }
            }
        }
    }

    private static void decreaseTemp() {
        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                if(i==1 || i == R || j==1 || j==C){
                    if(temp[i][j]!=0){
                        temp[i][j]--;
                    }
                }
            }
        }
    }

    private static void heat() {
        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                if(map[i][j] > 0){
                    makeWind(map[i][j],i,j);
                }
            }
        }
    }

    private static void makeWind(int direction, int x, int y) {
        if(direction == 2){
            //왼쪽
            int moveY = -1;
            //아래대각 위대각 직진
            int[] dx = {1,-1,0};
            int[] dy = {-1,-1,-1};
            if(checkInMap(x,y+moveY)) {
                Queue<Pair> q = new ArrayDeque<>();
                q.add(new Pair(x, y + moveY, 5));
                temp[x][y + moveY] += 5;
                search(direction, q, dx, dy);
            }

        } else if (direction == 1){
            //우측
            int moveY = 1;
            //전진 대각 bfs 아래대각 위대각 직진
            int[] dx = {1,-1,0};
            int[] dy = {1,1,1};
            if(checkInMap(x,y+moveY)) {
                Queue<Pair> q = new ArrayDeque<>();
                q.add(new Pair(x, y + moveY, 5));
                temp[x][y + moveY] += 5;
                search(direction, q, dx, dy);
            }
            //대각선
        } else if (direction == 3){
            //위
            int moveX = -1;
            //왼대각 우대각 직진
            int[] dx = {-1,-1,-1};
            int[] dy = {-1,1,0};
            if(checkInMap(x+moveX,y)) {
                Queue<Pair> q = new ArrayDeque<>();
                q.add(new Pair(x + moveX, y, 5));
                temp[x + moveX][y] += 5;
                search(direction, q, dx, dy);
            }
        }else if (direction == 4){
            //아래
            int moveX = 1;
            //왼대각 우대각 직진
            int[] dx = {1,1,1};
            int[] dy = {-1,1,0};
            if(checkInMap(x+moveX,y)) {
                Queue<Pair> q = new ArrayDeque<>();
                q.add(new Pair(x + moveX, y, 5));
                temp[x + moveX][y] += 5;
                search(direction, q, dx, dy);
            }
        }
    }

    private static void search(int direction, Queue<Pair> q, int[] dx, int[] dy) {
        boolean[][] checked = new boolean[R+1][C+1];
        while(!q.isEmpty()){
            final Pair now = q.poll();
            for (int i = 0; i < 3; i++) {
                int nx = now.x+ dx[i];
                int ny = now.y+ dy[i];

                if(!checkInMap(nx, ny)){
                    continue;
                }
                boolean check = false;
                if(direction == 1){
                    check = isCheck2(i, nx, ny, check);
                } else if(direction == 2) {
                    check = isCheck1(i, nx, ny, check);
                } else if(direction == 3) {
                    check = isCheck3(i, nx, ny, check);
                }else if(direction == 4) {
                    check = isCheck4(i, nx, ny, check);
                }

                if(check || checked[nx][ny]){
                    continue;
                }
                if(now.value==0){
                    break;
                }
                checked[nx][ny]=true;
                temp[nx][ny]+=now.value-1;
                q.add(new Pair(nx,ny,now.value-1));
            }
        }
    }

    private static boolean isCheck4(int i, int nx, int ny, boolean check) {
        //왼대각 우대각 직진
        if(i ==0){
            for (int j = 0; j < wall.size(); j++) {
                final Pair pair = wall.get(j);
                if(pair.x == nx && pair.y == ny && pair.value==0){
                    check = true;
                    //대각선 불가능
                }
                if(pair.x == nx-1 && pair.y == ny && pair.value==1){
                    check = true;
                    //대각선 불가능
                }
            }
        } else if(i ==1){
            for (int j = 0; j < wall.size(); j++) {
                final Pair pair = wall.get(j);
                if(pair.x == nx && pair.y == ny && pair.value ==0){
                    check = true;
                    //대각선 불가능
                }
                if(pair.x == nx-1 && pair.y == ny-1 && pair.value==1){
                    check = true;
                }
            }
        } else{
            for (int j = 0; j < wall.size(); j++) {
                final Pair pair = wall.get(j);
                if(pair.x == nx && pair.y == ny && pair.value==0){
                    check = true;
                    //대각선 불가능
                }
            }
        }
        return check;
    }

    private static boolean isCheck3(int i, int nx, int ny, boolean check) {
        //왼대각 우대각 직진

        if(i ==0){
            for (int j = 0; j < wall.size(); j++) {
                final Pair pair = wall.get(j);
                if(pair.x == nx+1 && pair.y == ny){
                    check = true;
                    //대각선 불가능
                }
            }
        } else if(i ==1){
            for (int j = 0; j < wall.size(); j++) {
                final Pair pair = wall.get(j);
                if(pair.x == nx +1 && pair.y == ny && pair.value ==0){
                    check = true;
                    //대각선 불가능
                }
                if(pair.x == nx+1 && pair.y == ny -1 && pair.value==1){
                    check = true;
                }
            }
        } else{
            for (int j = 0; j < wall.size(); j++) {
                final Pair pair = wall.get(j);
                if(pair.x == nx+1 && pair.y == ny && pair.value==0){
                    check = true;
                    //대각선 불가능
                }
            }
        }
        return check;
    }

    private static boolean isCheck1(int i, int nx, int ny, boolean check) {
        //위대각
        if(i ==1){
            for (int j = 0; j < wall.size(); j++) {
                final Pair pair = wall.get(j);
                if(pair.x == nx && pair.y == ny && pair.value == 1){
                    check = true;
                    //대각선 불가능
                }
                if(pair.x == nx+1 && pair.y == ny+1 && pair.value == 0){
                    check = true;
                    //대각선 불가능
                }
            }
        } else if(i ==0){
            for (int j = 0; j < wall.size(); j++) {
                final Pair pair = wall.get(j);
                if(pair.x == nx && pair.y == ny +1 && pair.value ==0){
                    check = true;
                    //대각선 불가능
                }
                if(pair.x == nx && pair.y == ny && pair.value==1){
                    check = true;
                }
            }
        } else{
            for (int j = 0; j < wall.size(); j++) {
                final Pair pair = wall.get(j);
                if(pair.x == nx && pair.y == ny && pair.value==1){
                    check = true;
                    //대각선 불가능
                }
            }
        }
        return check;
    }

    private static boolean isCheck2(int i, int nx, int ny, boolean check) {
        if(i ==0){
            for (int j = 0; j < wall.size(); j++) {
                final Pair pair = wall.get(j);
                if(pair.x == nx && pair.y == ny -1){
                    check = true;
                    //대각선 불가능
                }
            }
        } else if(i ==1){
            for (int j = 0; j < wall.size(); j++) {
                final Pair pair = wall.get(j);
                if(pair.x == nx +1 && pair.y == ny -1 && pair.value ==0){
                    check = true;
                    //대각선 불가능
                }
                if(pair.x == nx && pair.y == ny -1 && pair.value==1){
                    check = true;
                }
            }
        } else{
            for (int j = 0; j < wall.size(); j++) {
                final Pair pair = wall.get(j);
                if(pair.x == nx && pair.y == ny -1 && pair.value==1){
                    check = true;
                    //대각선 불가능
                }
            }
        }
        return check;
    }

    private static boolean checkInMap(int nx, int ny) {
        if(nx <1 || ny <1 || nx >R|| ny >C){
            return false;
        }
        return true;
    }

    private static boolean checkTemp() {
        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                if(map[i][j]==5 && temp[i][j]<K){
                    return true;
                }
            }
        }
        return false;
    }
}
