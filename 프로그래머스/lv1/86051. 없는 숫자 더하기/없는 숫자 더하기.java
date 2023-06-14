class Solution {
    public int solution(int[] numbers) {
        int sum=0;
        for(int i=0; i<=9; i++){
            boolean isExisted = false;
            for(int j=0; j<numbers.length; j++){
                if(numbers[j] == i){
                    isExisted = true;
                }
            }
            if(!isExisted){
                sum += i;
            }
        }
        return sum;
    }
}