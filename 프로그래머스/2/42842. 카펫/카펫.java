class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        int num = brown+yellow;
        for(int i=3; i<=num; i++){
            if(num%i != 0){
                continue;
            }
            int di = num/i;
            if(yellow == (i-2)*(di-2)){
                answer = new int[]{di, i};   
                break;
            }
        }
        return answer;
    }
}