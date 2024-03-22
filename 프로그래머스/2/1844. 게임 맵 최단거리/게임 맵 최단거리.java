import java.util.*;
class Solution {
    class Pair{
        int x;
        int y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    
    public int solution(int[][] maps) {
        int answer = 0;
        checked = new int[maps.length][maps[0].length];
        for(int i=0; i<maps.length; i++){
            for(int j=0; j<maps[0].length; j++){
                checked[i][j]=-1;
            }
        }
        bfs(new Pair(0,0), maps);
        return checked[maps.length-1][maps[0].length-1];
    }
    static int[][] checked;
    public void bfs(Pair start, int[][] maps){
        Queue<Pair> que = new ArrayDeque<>();
        que.add(start);
        checked[start.x][start.y] = 1;
        while(!que.isEmpty()){
            Pair p = que.poll();
            for(int i=0; i<4; i++){
                int nx = p.x+dx[i];
                int ny = p.y+dy[i];
                
                if(nx<0 || ny<0|| nx>=maps.length || ny>=maps[0].length){
                    continue;
                }
                if(maps[nx][ny]==0 || (checked[nx][ny]!=-1 && checked[nx][ny] <= checked[p.x][p.y]+1)){
                    continue;
                }
                checked[nx][ny]=checked[p.x][p.y]+1;
                que.add(new Pair(nx,ny));
            }
        }
    }
}