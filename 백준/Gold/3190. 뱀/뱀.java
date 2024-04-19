import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class command {
        int time;
        String command;

        public command(int time, String command) {
            this.time = time;
            this.command = command;
        }
    }
    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static List<command> commands;
    static List<Pair> snake;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int move = 0;
    static int commandIndex = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N+1][N+1];
        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x][y]=1;
        }
        arr[1][1] = -1;
        commands = new ArrayList<>();
        snake = new ArrayList<>();
        snake.add(new Pair(1,1));
        int L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            String c = st.nextToken();
            commands.add(new command(t,c));
        }
        int time=0;
        while(true){
            time++;
            if(snake.size() ==0){
                break;
            }
            int headX = snake.get(0).x;
            int headY = snake.get(0).y;
            int tailX = snake.get(snake.size()-1).x;
            int tailY = snake.get(snake.size()-1).y;
            if(move<0 || move>3){
                break;
            }
            if(headX+dx[move]<1 ||headX+dx[move]>N ||headY+dy[move]<1 || headY+dy[move]>N){
                break;
            }
            //사과를 먹는다.
            if(arr[headX+dx[move]][headY+dy[move]] == 1){
                arr[headX+dx[move]][headY+dy[move]] = -1;
                snake.add(0,new Pair(headX+dx[move],headY+dy[move]));
            } else{
                if(arr[headX+dx[move]][headY+dy[move]] == -1){
                    break;
                }
                arr[headX+dx[move]][headY+dy[move]] = -1;
                arr[tailX][tailY] = 0;
                snake.add(0,new Pair(headX+dx[move],headY+dy[move]));
                snake.remove(snake.size()-1);
            }
            
            //뱀이 방향을 회전한다.
            if(commandIndex < commands.size() && commands.get(commandIndex).time==time){
                //방향 회전
                if(commands.get(commandIndex).command.equals("D")){
                    move +=1;
                    move%=4;
                } else if(commands.get(commandIndex).command.equals("L")){
                    move -= 1;
                    if(move<0){
                        move+=4;
                    }
                }
                commandIndex++;
            }
            //만약 뱀이 자신의 몸, 벽과 부딪히면 죽는다.
        }
        System.out.println(time);
    }
}

/*
6
0
4
2 D
7 L
8 L
10 L
 */
