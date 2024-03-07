import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        
        PriorityQueue<Integer> deq = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> deqreve = new PriorityQueue<>();
        for(int i=0; i<operations.length; i++){
            String[] strs= operations[i].split(" ");
            if(strs[0].equals("I")){
                deq.add(Integer.parseInt(strs[1]));
                deqreve.add(Integer.parseInt(strs[1]));
                            
            } else if(strs[1].equals("1")){
                Integer num = deq.poll();
                deqreve.remove(num);
            } else{
                Integer num =deqreve.poll();
                deq.remove(num);
            }
        }
        Integer max = deq.size()==0?0:deq.poll();
        Integer min = deqreve.size()==0?0:deqreve.poll();
        
        int[] answer = {max, min};
        return answer;
    }
}