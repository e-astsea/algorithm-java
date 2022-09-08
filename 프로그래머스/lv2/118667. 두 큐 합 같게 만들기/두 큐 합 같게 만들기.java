import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        long q1sum=0;
        long q2sum=0;
        ArrayList<Integer> q1 = new ArrayList<>();
        ArrayList<Integer> q2 = new ArrayList<>();
        long size=0;
            
        for(int i=0; i<queue1.length; i++){
            q1sum+=queue1[i];
            q1.add(queue1[i]);
            size++;
        }
        for(int i=0; i<queue2.length; i++){
            q2sum+=queue2[i];
            q2.add(queue2[i]);
            size++;
        }
        long result = (q1sum+q2sum)/2;
        int answer = 0;
        int q1cnt=0;
        int q2cnt=0;
        while(true){
            if(q1sum==result && q2sum==result){
                break;
            }
            if(q1sum>q2sum){
                q2.add(q1.get(q1cnt));
                q1sum-=q1.get(q1cnt);
                q2sum+=q1.get(q1cnt++);
            }
            else if(q1sum<q2sum){
                q1.add(q2.get(q2cnt));
                q1sum+=q2.get(q2cnt);
                q2sum-=q2.get(q2cnt++);
            }
            
            answer++;
            if(answer>600000){
                return -1;
            }
        }
        
        
        
        
        
        
        
        
        return answer;
    }
    
}