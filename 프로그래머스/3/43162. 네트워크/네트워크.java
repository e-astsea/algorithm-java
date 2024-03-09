import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] checked = new boolean[computers.length];
        
        for(int i=0; i<computers.length; i++){
            if(checked[i]){
                continue;
            }
            answer++;
            checked[i]=true;
            dfs(i,computers, checked);
        }
        
        return answer;
    }
    
    public void dfs(int start, int[][] computers, boolean[] checked){
        for(int i=0; i<computers[start].length; i++){
            if(computers[start][i]==0 || checked[i]){
                continue;
            }
            checked[i]=true;
            dfs(i,computers,checked);
        }
    }
}