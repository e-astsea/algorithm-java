import java.util.*;
class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        int[] arr = new int[n+2];
        for(int i=0; i<arr.length;i++){
            arr[i] = 50001;
        }
        
        List<List<Integer>> ls = new ArrayList<>();
        for(int i=0; i<=n; i++){
            ls.add(new ArrayList<>());
        }
        for(int i=0; i<edge.length; i++){
            int first = edge[i][0];
            int second = edge[i][1];
            ls.get(first).add(second);
            ls.get(second).add(first);
        }
        
        dfs(1,ls,arr,0);
        
        for(int i=1; i<=n; i++){
            System.out.println(arr[i]);
        }
        Arrays.sort(arr);
        int tmp = -1;
        for(int i=n+1; i>=0; i--){
            if(arr[i]==50001){
                continue;
            } else{
                if(tmp == -1){
                    tmp = arr[i];
                    answer++;
                } else if(tmp != arr[i]){
                    break;
                } else{
                    answer++;
                }
            }
        }
        return answer;
    }
    
    public void dfs(int start, List<List<Integer>> ls, int[] arr, int depth){
        arr[start]=Math.min(depth,arr[start]);
        for(int i=0; i<ls.get(start).size(); i++){
            if(arr[ls.get(start).get(i)]>depth+1)
            dfs(ls.get(start).get(i),ls,arr,depth+1);
        }
    }
}