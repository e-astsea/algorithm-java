class Solution {
    public int solution(int n) {
        int answer = 0;
        int i = 1;
        while(true){
            int sqrt = i*i;
            if(sqrt==n){
                answer=1;
                break;
            } else if(sqrt>n){
                answer=2;
                break;
            }
            i++;
        }
        return answer;
    }
}