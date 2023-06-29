import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
            
        Deque<Integer> st = new ArrayDeque<>();

        for(int i=0; i<arr.length; i++){
            if(st.isEmpty() || st.getLast() != arr[i]){
                st.addLast(arr[i]);
            }
        }
        int[] answer = new int[st.size()];
        int num = st.size();
        for(int i=0; i<num; i++){
             answer[i] = st.removeFirst();
        }

        return answer;
    }
}