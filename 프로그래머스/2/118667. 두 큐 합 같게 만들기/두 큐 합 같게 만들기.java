import java.util.*;

class Solution {
        public long solution(int[] queue1, int[] queue2) {
        Queue<Long> q1 = new LinkedList<>();
        Queue<Long> q2 = new LinkedList<>();
        long sum1 = 0;
        long sum2 = 0;

        for (int i = 0; i < queue1.length; i++) {
            q1.add((long)queue1[i]);
            sum1+=queue1[i];
        }
        for (int i = 0; i < queue2.length; i++) {
            q2.add((long)queue2[i]);
            sum2+=queue2[i];
        }
        long target = (sum1+sum2)/2;

        long count=0;
        while(true){
            if(q1.isEmpty() || q2.isEmpty()){
                count=-1;
                break;
            }
            if(sum1>target){
                final long num = q1.poll();
                q2.add(num);
                sum1-=num;
                sum2+=num;
                count++;
            }
            if(sum2>target){
                final long num = q2.poll();
                q1.add(num);
                sum1+=num;
                sum2-=num;
                count++;
            }
            if(sum1==target && sum2==target){
                break;
            }
            if(count>600000){
                count=-1;
                break;
            }
        }

        return count;
    }
}
    