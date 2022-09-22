import java.util.*;

class Solution {
    static char [][] arr;
    static int [][] checked;
    static int result=0;
    static int check=0;
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        arr = new char[m+1][n+1];
        checked = new int[m+1][n+1];
        for(int i=m-1; i>=0; i--){
            for(int j=0; j<n;j++){
                arr[i][j]=board[i].charAt(j);
            }
        }
        
        while(true){
        
        find(n,m);
        makeempty(n,m);
        down(n,m);
            if(check==0){
            break;
            }
        }

        answer = result;
        
        return answer;
    }
    public void print(int n, int m){
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                System.out.print(arr[i][j]);
            }
            System.out.println("");
        }
    }
    public void down(int n, int m){
        for(int i=n-1; i>=0; i--){
            int flag = 0;
            int a=0,b=0;
            int tmpa=0;
            for(int j=m-1; j>=0; j--){
                if(arr[j][i]=='#' && flag==0){
                    a=j;
                    b=i;
                    flag=1;
                }
                if(flag==1 && arr[j][i]!='#'){
                    char tmp = arr[a][b];
                    arr[a][b]=arr[j][i];
                    arr[j][i]=tmp;
                    flag=0;
                    j=m-1;
                }
            }
        }
    }
    public void makeempty(int n, int m){
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(checked[i][j]==1){
                    arr[i][j]='#';
                    result++;
                }
            }
        }
        checked = new int[m+1][n+1];

    }
    public void find(int n, int m){
        check=0;
         for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(j+1 >n || i-1<0 || arr[i][j]=='#'){
                    continue;
                }
                if(arr[i][j] == arr[i][j+1] && arr[i][j] == arr[i-1][j+1] && arr[i][j] == arr[i-1][j]){
                    checked[i][j]=1;
                    checked[i][j+1]=1;
                    checked[i-1][j+1]=1;
                    checked[i-1][j]=1;
                    check=1;
                }
            }
        }
    }
}