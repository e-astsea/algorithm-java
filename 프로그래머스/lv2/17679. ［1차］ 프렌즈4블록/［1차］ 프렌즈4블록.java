import java.util.*;

class Solution {
    static int[] dx = {1,1,0};
    static int[] dy = {0,-1,-1};
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        
        char [][] arr = new char[m+1][n+1];
        int [][] checked = new int[m+1][n+1];
        for(int i=m-1; i>=0; i--){
            for(int j=0; j<n;j++){
                arr[i][j]=board[i].charAt(j);
            }
        }
        
        bfs(arr,checked,0,0,m,n);
         for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                //System.out.print(checked[i][j]);
                System.out.print(arr[i][j]);
            }
             System.out.println("");
         }
        return answer;
    }
    
    public void bfs(char [][]arr,int [][]checked,int x,int y,int m,int n){
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(checked[i][j]==1){
                    continue;
                }
                checked[i][j]=1;
                for(int k=0; k<3; k++){
                    int nx = dx[k]+i;
                    int ny = dy[k]+j;
                    
                    if(ny>=n || ny<0 || nx<0 || nx>=m){
                        checked[i][j]=0;
                        break;
                    }
                    if(arr[x][y]!=arr[nx][ny]){
                        checked[i][j]=0;
                        break;
                    }
                    checked[nx][ny]=1;
                }
            }
        }
        
    }
}