import java.util.*;
class Solution {
    public class Pair{
        int p;
        int location;
        public Pair(int p, int l){
            this.p = p;
            this.location = l;
        }
    }
    public int solution(int[] priorities, int location) {
        int answer = 0;
        List<Integer> ls = new ArrayList<>();
        for(int i=0; i<priorities.length; i++){
            ls.add(priorities[i]);
        }
        Collections.sort(ls,Collections.reverseOrder());
        int index = 0;
        
        Queue<Pair> q = new ArrayDeque<>();
        for(int i=0; i<priorities.length; i++){
            q.add(new Pair(priorities[i],i));
        }
        
        while(!q.isEmpty()){
            Pair p = q.poll();
            if(p.p != ls.get(index)){
                q.add(p);
            } else{
                if(p.location == location){
                    // System.out.println(p.p+" "+p.location+" "+location);   
                    answer = index+1;
                    break;
                }
                index++;
            }
        }
        
        return answer;
    }
}