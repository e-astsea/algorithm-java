import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        List<Integer> ans = new ArrayList<>();
        for(int i=0; i< numbers.length; i++){
            for(int j=i+1; j<numbers.length; j++){
                int sum = numbers[i] + numbers[j];
                if(!ans.contains(sum)){
                    ans.add(sum);
                }
            }
        }
        Collections.sort(ans);
        int[] answer = new int[ans.size()];
        for(int i=0; i<ans.size(); i++){
            answer[i] = ans.get(i);
        }
        return answer;
    }
}