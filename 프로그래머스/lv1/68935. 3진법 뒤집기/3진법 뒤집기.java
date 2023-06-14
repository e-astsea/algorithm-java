import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(int n) {
        
        List<Integer> answer = new ArrayList<>();
        while(n>0){
            int temp = n%3;
            n/=3;
            answer.add(temp);
            System.out.println(temp);
        }
        
        int ans = 0;
        int tmp = 1;
        for(int i = answer.size() - 1; i>=0; i--){
            ans += answer.get(i)*(Math.pow(3,(answer.size()-1) - i));
        }
        
        return ans;
    }
}