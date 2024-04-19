import java.util.*;
class Solution {
    class Pair{
        int x;
        int y;
        int depth;
        public Pair(int x, int y, int depth){
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,1,-1};
    
    public int solution(int[][] maps) {
        int answer = 0;
        return bfs(maps);
    }
    public int bfs(int[][] maps){
        Queue<Pair> q = new ArrayDeque<>();
        int[][] checked = new int[maps.length][maps[0].length];
        
        q.add(new Pair(0,0,1));
        checked[0][0]=1;
        
        while(!q.isEmpty()){
            Pair now = q.poll();
            for(int i=0; i<4; i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if(nx<0 || ny<0 || nx>=maps.length || ny>=maps[0].length){
                    continue;
                }
                if(maps[nx][ny]==0){
                    continue;
                }
                if(checked[nx][ny]>0){
                    continue;
                }
                checked[nx][ny]=now.depth+1;
                q.add(new Pair(nx,ny,now.depth+1));
            }
        }
        if(checked[maps.length-1][maps[0].length-1] == 0){
            return -1;
        } else{
        return checked[maps.length-1][maps[0].length-1];
        }
    }
}