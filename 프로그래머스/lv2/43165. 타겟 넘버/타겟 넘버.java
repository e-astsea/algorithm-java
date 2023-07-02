class Solution {
    int answer = 0;
    int[] nums;
    public int solution(int[] numbers, int target) {
        nums = numbers;
        dfs(0 , target, 0);
        return answer;
    }
    
    public void dfs(int result, int target, int index){
        if(index == nums.length){
            if(result == target){
                answer++;
            }
            return;
        }
        int nextNum = index+1;
        dfs(result + nums[index],target,nextNum);
        dfs(result - nums[index],target,nextNum);
    }
}