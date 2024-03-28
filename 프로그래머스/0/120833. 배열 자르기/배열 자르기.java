import java.util.*;
class Solution {
    public List<Integer> solution(int[] numbers, int num1, int num2) {
        int[] answer = {};
        List<Integer> ls = new ArrayList<>();
        for(int i=num1; i<=num2; i++){
            ls.add(numbers[i]);
        }
        return ls;
    }
}