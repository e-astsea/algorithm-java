class Solution {
    static int N;
    static int one;
    static int zero;
    public int[] solution(int[][] arr) {
        int[] answer = {};
        //분할 정복
        N = arr.length;
        
        one = 0;
        zero = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(arr[i][j] == 1){
                    one++;
                } else{
                    zero++;
                }
            }
        }

        dfs(arr,0,0,arr[0].length);
        int[] result = {zero,one};
        return result;
    }
    
    public void dfs(int[][] arr, int x, int y, int len){
        boolean check = true;
        int num = arr[x][y];
        for(int i=x; i<x+len; i++){
            for(int j=y; j<y+len; j++){
                if(num != arr[i][j]){
                    check=false;
                }
            }
        }
        if(check && len >1){
            System.out.println(len);
            if(num == 1){
                one -= len*len;
                one++;
            } else{
                zero -= len*len;
                zero++;
            }
            return;
        } else if(len==1){
            return;
        }
        dfs(arr,x,y,len/2);
        dfs(arr,x+len/2,y,len/2);
        dfs(arr,x,y+len/2,len/2);
        dfs(arr,x+len/2,y+len/2,len/2);
    }
}