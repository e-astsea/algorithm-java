import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        List<List<Integer>> ls = new ArrayList<>();
        for(int i=0; i<n; i++){
            ls.add(new ArrayList<>());
        }
        
        for(int i=0; i<computers.length; i++){
            for(int j=0; j<computers[i].length; j++){
                if(computers[i][j]==1){
                    ls.get(i).add(j); 
                }
            }
        }
        boolean[] checked = new boolean[n];
        
        for(int i=0; i<n; i++){
            if(checked[i]){
                continue;
            }
            dfs(ls,checked,i);
            answer++;
        }
        return answer;
    }
    
    public void dfs(List<List<Integer>> ls, boolean[] checked,int start){
        
        for(int i=0; i<ls.get(start).size(); i++){
            if(checked[ls.get(start).get(i)]){
                continue;
            }
            checked[ls.get(start).get(i)] = true;
            dfs(ls,checked,ls.get(start).get(i));
        }
    }
}