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
        int answer = 0;
        int[][] arr = new int[N + 1][N + 1];
        boolean[][] cloud = new boolean[N + 1][N + 1];

        cloudInit(cloud, N);

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            final boolean[][] moveClouds = moveCloud(d, s, cloud, N);
            rain(moveClouds, arr, N);
            cloud = makeCloud(moveClouds,arr,N);
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <=N ; j++) {
                answer += arr[i][j];
            }
        }

        System.out.println(answer);
    }

    private static boolean[][] makeCloud(boolean[][] moveClouds, int[][] arr, int n) {
        boolean[][] cloudTmp = new boolean[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(arr[i][j]>=2 && !moveClouds[i][j]){
                    cloudTmp[i][j]=true;
                    arr[i][j]-=2;
                }
            }
        }
        return cloudTmp;
    }

    private static void rain(boolean[][] moveClouds, int[][] arr, int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(moveClouds[i][j]){
                    arr[i][j]++;
                }
            }
        }
        magic(moveClouds, arr, n);
//        대각선 방향으로 거리가 1인 칸에 물이 있는
//        바구니만큼 현재 바구니의 물의 양이 증가한다. 경계를 넘지는 안흔ㄴ다.
    }

    private static void magic(boolean[][] moveClouds, int[][] arr, int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(moveClouds[i][j]){
                    for (int k = 1; k < 8; k+=2) {
                        int nx = i+dx[k];
                        int ny = j+dy[k];

                        if(nx<1 || ny<1 || nx>n || ny>n){
                            continue;
                        }
                        if(arr[nx][ny] != 0){
                            arr[i][j]++;
                        }
                    }
                }
            }
        }

    }

    static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};


    // 0 1 2 3 4에서 0에서 -1이면 4로 -2면 3으로 -3 -> 2 -4 -> 1 -5 -> 0 -6 -> 4
    private static boolean[][] moveCloud(int d, int s, boolean[][] cloud, int N) {
        boolean[][] cloudTmp = new boolean[N+1][N+1];
        for (int i = 1; i <=N ; i++) {
            for (int j = 1; j <= N ; j++) {
                if(cloud[i][j]){
                    int nx = (i + dx[d - 1] * s) % N; // 다음 x 좌표 계산
                    while (nx <= 0) nx += N; // 음수가 나올 때까지 반복해서 N을 더함

                    int ny = (j + dy[d - 1] * s) % N; // 다음 y 좌표 계산
                    while (ny <= 0) ny += N; // 음수가 나올 때까지 반복해서 N을 더함


                    if(nx==0) nx = N;
                    if(ny==0) ny=N;
//                    int nx = i+dx[d-1] * s;
//                    int ny = j+dy[d-1] * s;
//                    if(nx<1){
//                        nx = -1*nx%N;
////                        nx+=N;
//                    }
//                    if(ny<1){
////                        ny+=N;
//                        ny = -1*ny%N;
//                    }
//                    if(nx>N){
////                        nx-=N;
//                        nx = N+1-nx%N;
//
//                    }
//                    if(ny>N){
////                        ny-=N;
//                        ny = N+1-ny%N;
//
//                    }
                    cloudTmp[nx][ny] = true;
                }
            }
        }
        return cloudTmp;
    }

    private static void cloudInit(boolean[][] cloud, int N) {
        cloud[N][1] = true;
        cloud[N][2] = true;
        cloud[N - 1][1] = true;
        cloud[N - 1][2] = true;
    }
}
/*
비바라기를 시전하면 (N, 1), (N, 2), (N-1, 1), (N-1, 2)에 비구름이 생긴다.
이동을 시킨다.
1~8개 정수로

1. 모든 구름이 di방향으로 si칸 이동한다.
2. 구름에서 비가 내려 구름 칸 바구니에 물의 양이 증가한다.
3. 구름이 모두 사라진다.
4. 2에서 증가한 칸에 물복사버그마법을 시전한다. 대각선 방향으로 거리가 1인 칸에 물이 있는
    바구니만큼 현재 바구니의 물의 양이 증가한다. 경계를 넘지는 안흔ㄴ다.
5. 바구니에 저장된 물의 양이 2 이상인 칸에 구름이 생기고, 물의 양이 줄어든다.
    이 때 구름이 생기는 칸은 3번에서 사라진 칸이 아니어야한다,
 */
