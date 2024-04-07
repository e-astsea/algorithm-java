import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Status{
        int num;
        int d;
        Status(int num, int d){
            this.num = num;
            this.d = d;
        }
    }
    static List<List<Integer>> ls;
    static Queue<Status> q;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ls = new ArrayList<>();
        q = new ArrayDeque<>();

        for (int i = 0; i < 4; i++) {
            ls.add(new ArrayList<>());
        }

        for (int i = 0; i < 4; i++) {
            final String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                ls.get(i).add(Integer.parseInt(String.valueOf(s.charAt(j))));
            }
        }

        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int turnNumber = Integer.parseInt(st.nextToken());
            int turnDirection = Integer.parseInt(st.nextToken());
            //1일경우 시계방향 -1일경우 반시계방향

            q.add(new Status(turnNumber-1,turnDirection));
            left(turnNumber-1, turnDirection,true);
            right(turnNumber-1, turnDirection, true);

            while(!q.isEmpty()){
                final Status status = q.poll();

                if(status.d == 1){
                    //시계
                    ls.get(status.num).add(0,ls.get(status.num).get(ls.get(status.num).size()-1));
                    ls.get(status.num).remove(ls.get(status.num).size()-1);
                } else if(status.d == -1){
                    //반시계
                    ls.get(status.num).add(ls.get(status.num).get(0));
                    ls.get(status.num).remove(0);
                }
            }
        }

        answer += ls.get(0).get(0) == 0 ? 0 : 1;
        answer += ls.get(1).get(0) == 0 ? 0 : 2;
        answer += ls.get(2).get(0) == 0 ? 0 : 4;
        answer += ls.get(3).get(0) == 0 ? 0 : 8;
        System.out.println(answer);
    }

    private static void left(int turnNumber, int turnDirection, boolean isMoved) {
        if(turnNumber<=0){
            return;
        }

        if(ls.get(turnNumber).get(6) == ls.get(turnNumber-1).get(2)){

        } else if(turnDirection == 1){
            q.add(new Status(turnNumber-1,-1));
            left(turnNumber-1, -1,true);
        } else if(turnDirection == -1){
            q.add(new Status(turnNumber-1,1));
            left(turnNumber-1, 1,true);
        }
    }

    private static void right(int turnNumber, int turnDirection, boolean isMoved) {
        if(turnNumber >= 3){
            return;
        }
        if(ls.get(turnNumber).get(2) == ls.get(turnNumber+1).get(6) ){

        } else if(turnDirection == 1){
            q.add(new Status(turnNumber+1,-1));
            right(turnNumber+1,-1,true);
        } else if(turnDirection == -1){
            q.add(new Status(turnNumber+1,1));
            right(turnNumber+1,1,true);
        }
    }
}

/*
0이면 N극, 1이면 S극

톱니바퀴는 왼,오 한칸 회전시킬 수 있다.
A와 맞닿은 B의톱니의 극이 다르면 B는 A회전방향 반대로 움직인다.
극이 같으면 회전하지 않는다.
옆 것이 움직이지 않았으면 회전하지 않는다.

회전하기 전 붙어있는 상태에 따라 다름
 */
