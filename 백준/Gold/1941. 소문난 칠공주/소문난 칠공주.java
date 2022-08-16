import java.io.*;
import java.util.*;


class pair{
    int x;
    int y;
    char par;
    pair(int x, int y, char par){
        this.x = x;
        this.y = y;
        this.par = par;
    }
    pair(int x, int y){
        this.x = x;
        this.y=y;
    }
}
public class Main {
    static ArrayList<pair> al;
    static ArrayList<pair> result;
    static int [] checked;
    static int[][] test;
    static int[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int finalresult=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        al = new ArrayList<>();
        result = new ArrayList<>();

        for(int i=0; i<5; i++){
            String str = br.readLine();
            for(int j=0; j<5; j++){
                al.add(new pair(i,j,str.charAt(j)));
            }
        }
        checked = new int[al.size()];

        dfs(0,0);
        System.out.println(finalresult);
    }
    static void dfs(int start,int depth){
        if(depth == 7){
            for(int i=0; i<al.size(); i++){
                if(checked[i]==1){
                    pair p = al.get(i);
                    result.add(p);
                }
            }
            test = new int[5][5];
            visited = new int[5][5];

            int k = bfs();
            if(k == 7){
                int s=0;
                int y=0;
                for(int i=0; i<result.size(); i++){
                    pair p = result.get(i);
                    if(p.par == 'Y'){
                        y++;
                    }
                    else if(p.par =='S'){
                        s++;
                    }
                }
                if(s>y)
                    finalresult++;
            }

            result.clear();
            return;
        }

        for(int i=start; i<al.size(); i++){
            if(checked[i]==1)
                continue;
            checked[i]=1;
            dfs(i+1,depth+1);
            checked[i]=0;
        }
    }
    static int bfs() {
        for (int i = 0; i < result.size(); i++) {
            pair p = result.get(i);
            test[p.x][p.y] = 1;
        }


        Queue<pair> queue = new LinkedList<pair>();
        visited[result.get(0).x][result.get(0).y] = 1;
        queue.add(new pair(result.get(0).x, result.get(0).y));
        int cnt = 0;
        while (!queue.isEmpty()) {
            pair tmp = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if ((nx >= 0 && ny >= 0) && (nx < 5 && ny < 5)) {
                    if (test[nx][ny] == 1 && visited[nx][ny] != 1) {
                        queue.add(new pair(nx, ny));
                        visited[nx][ny] = 1;
                        cnt++;
                    }
                }
            }
        }
        if (cnt == 6) {
            return 7;
        }
        return 0;
    }

}