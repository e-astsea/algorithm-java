class Solution {
    static int[] checked = new int[2];
    static int result=0;
    int count=0;
    public int solution(int[] numbers, int target) {
        int answer = 0;
        dfs(numbers,target,0);
        answer=count;
        return answer;
    }
    
    public void dfs(int[] numbers, int target,int i){
            
            if(i==numbers.length){
                if(result==target){
                count++;
                }
                return;
            }
            for(int j=0; j<2; j++){
                if(j==1){
                    result -= numbers[i];
                }
                else{
                    result += numbers[i];
                }
                
                dfs(numbers,target,i+1);
                
                if(j==1){
                    result += numbers[i];
                }
                else{
                    result -= numbers[i];
                }
             }
    }
}