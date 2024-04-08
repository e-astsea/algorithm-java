import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static class Pair {
        int x;
        int y;
        int space;
        int likeFriends;

        public Pair(int x, int y, int space, int likeFriends) {
            this.x = x;
            this.y = y;
            this.space = space;
            this.likeFriends = likeFriends;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<List<Integer>> ls = new ArrayList<>();
        for (int i = 0; i <= N * N; i++) {
            ls.add(new ArrayList<>());
        }
        int answer = 0;
        int[][] arr = new int[N][N];

        for (int i = 0; i < N * N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int student = Integer.parseInt(st.nextToken());
            ls.get(student).add(Integer.parseInt(st.nextToken()));
            ls.get(student).add(Integer.parseInt(st.nextToken()));
            ls.get(student).add(Integer.parseInt(st.nextToken()));
            ls.get(student).add(Integer.parseInt(st.nextToken()));

            //좋아하는 학생 탐색해서 인접칸 구하기
            final List<Pair> pairs = find(ls, N, arr, student);

            pairs.sort((o1, o2) -> {
                //친구가 가장 많아야함
                // 인접 칸 중 빈칸이 많은칸
                // 행의 번호가 작고, 열의 번호가 작은 칸
                if (o1.likeFriends != o2.likeFriends) {
                    return o2.likeFriends - o1.likeFriends;
                }
                if (o1.space != o2.space) {
                    return o2.space - o1.space;
                }
                if (o1.x != o2.x) {
                    return o1.x - o2.x;
                }
                return o1.y - o2.y;
            });
            final Pair pair = pairs.get(0);
            arr[pair.x][pair.y] = student;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int count = 0;
                for (int k = 0; k < 4; k++) {
                    int nx = dx[k] + i;
                    int ny = dy[k] + j;
                    if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                        continue;
                    }
                    if(ls.get(arr[i][j]).contains(arr[nx][ny])){
                        count++;
                    }
                }
                if(count == 1){
                    answer += 1;
                } else if (count == 2) {
                    answer +=10;
                } else if (count==3) {
                    answer +=100;
                } else if (count==4) {
                    answer +=1000;
                }
            }
        }
        System.out.println(answer);
    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    private static List<Pair> find(List<List<Integer>> ls, int N, int[][] arr, int student) {
        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] != 0) {
                    continue;
                }
                int space = 0;
                int likeFriend = 0;
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                        continue;
                    }
                    if (arr[nx][ny] != 0 && ls.get(student).contains(arr[nx][ny])) {
                        likeFriend++;
                    } else if (arr[nx][ny] == 0) {
                        space++;
                    }
                }
                pairs.add(new Pair(i, j, space, likeFriend));
            }
        }
        return pairs;
    }
}
/*
x1 - x2 + y1- y2 = 1이어야 인접하다고 한다.

1. 빈 칸 중 좋아하는 학생이 인접한 칸에 가장 많은 칸으로 정한다.
2. 1을 만족하는게 여러개라면 인접 칸 중 빈 칸이 가장 많은 칸으로 정한다.
3. 2를 만족하는 칸도 여러개면 행의 번호가 가장 작은칸, 그것도 여러개면 열의 번호가 가장 작은칸으로 정한다.

 */
