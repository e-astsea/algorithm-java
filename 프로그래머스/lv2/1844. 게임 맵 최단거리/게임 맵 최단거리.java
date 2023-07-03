import java.util.*;

class Pair{
    int x;
    int y;
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class Solution {
    int[] dx = {-1,0,1,0};
    int[] dy = {0,-1,0,1};
    int[][] checked;
    
    public int solution(int[][] maps) {
        int answer = 0;
        checked = new int[maps.length][maps[0].length];
        
        for(int i=0; i<maps.length; i++){
            for(int j=0; j<maps[0].length; j++){
                checked[i][j] = Integer.MAX_VALUE;
            }
        }
        answer = bfs(maps);
        return answer;
    }
    
    public int bfs(int[][] maps){
        Queue<Pair> q = new ArrayDeque<>();
        checked[maps.length-1][maps[0].length-1]=Integer.MAX_VALUE;
        
        int answer = 0;
        
        q.add(new Pair(0,0));
        checked[0][0] = 1;
        
        while(!q.isEmpty()){
            Pair pair = q.poll();
            for(int i=0; i<4; i++){
                int nx = pair.x+dx[i];
                int ny = pair.y+dy[i];
                
                if(nx>=0 && ny>=0 && nx<maps.length && ny<maps[0].length){
                    if(maps[nx][ny] == 1 && checked[nx][ny] > checked[pair.x][pair.y] + 1) {
                        q.add(new Pair(nx, ny));
                        checked[nx][ny] = checked[pair.x][pair.y] + 1;
                    }
                }
            }
        }
        
        if(checked[maps.length-1][maps[0].length-1] == Integer.MAX_VALUE ){
            return -1;
        }
        return checked[maps.length-1][maps[0].length-1];
    }
}