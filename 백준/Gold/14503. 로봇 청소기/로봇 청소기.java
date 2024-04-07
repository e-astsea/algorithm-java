import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Status{
        int x;
        int y;
        int d;
        Status(int x, int y, int d){
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int status = Integer.parseInt(st.nextToken());
                arr[i][j]=status;
            }
        }

        bfs(new Status(r,c,d),arr);
        System.out.println(answer);
    }
    static int answer = 0;
    private static void bfs(Status status, int[][] arr) {

        Queue<Status> q = new ArrayDeque<>();
        q.add(status);

        while(!q.isEmpty()){
            final Status now = q.poll();
            if(arr[now.x][now.y] == 0){
                arr[now.x][now.y] = 2;
                answer++;
            }

            if(check(arr, now.x,now.y)){ //청소 안된곳이 있음 3번
                for (int i = 1; i <= 4; i++) {
                    int move = now.d - i;
                    if (move < 0) {
                        move += 4;
                    }
                    if (move == 0 && now.x-1>=0 && arr[now.x - 1][now.y] == 0) {
                        if (arr[now.x - 1][now.y] == 0) {
                            q.add(new Status(now.x - 1, now.y, 0));
                        } else {
                            q.add(new Status(now.x, now.y, 0));
                        }
                        break;
                    } else if (move == 1 && now.y+1<arr[0].length &&arr[now.x][now.y + 1] == 0) {
                        if (arr[now.x][now.y + 1] == 0) {
                            q.add(new Status(now.x, now.y + 1, 1));
                        } else {
                            q.add(new Status(now.x, now.y, 1));
                        }
                        break;
                    } else if (move == 2 && now.x+1<arr.length&&arr[now.x + 1][now.y] == 0) {
                        if (arr[now.x + 1][now.y] == 0) {
                            q.add(new Status(now.x + 1, now.y, 2));
                        } else {
                            q.add(new Status(now.x, now.y, 2));
                        }
                        break;

                    } else if (move == 3 &&now.y-1>=0&& arr[now.x][now.y - 1] == 0) {
                        if (arr[now.x][now.y - 1] == 0) {
                            q.add(new Status(now.x, now.y - 1, 3));
                        } else {
                            q.add(new Status(now.x, now.y, 3));
                        }
                        break;

                    }
                }
            } else{ //2번
                if(now.d == 0){
                    if(now.x+1>=arr.length || arr[now.x+1][now.y] == 1){
                        break;
                    }
                    q.add(new Status(now.x+1,now.y,0));
                } else if(now.d == 1){
                    if(now.y-1<0 || arr[now.x][now.y-1] == 1){
                        break;
                    }
                    q.add(new Status(now.x,now.y-1,1));
                } else if(now.d == 2){
                    if(now.x-1<0 || arr[now.x-1][now.y] == 1){
                        break;
                    }
                    q.add(new Status(now.x-1,now.y,2));
                } else if(now.d == 3){
                    if(now.y+1>=arr[0].length || arr[now.x][now.y+1] == 1){
                        break;
                    }
                    q.add(new Status(now.x,now.y+1,3));
                }
            }
        }
    }

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    private static boolean check(int[][] arr, int x, int y) {
        for (int i = 0; i < 4; i++) {
            if(x+dx[i] <0 || y+dy[i] <0 || x+dx[i]>=arr.length || y+dy[i]>=arr[0].length){
                continue;
            }
            if(arr[x+dx[i]][y+dy[i]] ==0){
                return true;
            }
        }
        return false;
    }
}

