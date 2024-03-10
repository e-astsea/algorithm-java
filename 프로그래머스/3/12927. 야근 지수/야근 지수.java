import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<works.length;i++){
            pq.add(works[i]);
        }
        
        for(int i=0; i<n; i++){
            if(pq.size()==0){
                break;
            }
            
            int num =pq.poll();

            if(num-1!=0){
                pq.add(num-1);
            }
        }
        
        int size = pq.size();
        for(int i=0; i<size; i++){
            int num = pq.poll();
            answer += (num*num);
        }
        return answer;
    }
}