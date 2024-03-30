class Solution {
    public int[] solution(int[] num_list) {

        int divide2 = 0;
        int nondivide2 = 0;
        for(int i=0; i<num_list.length; i++){
            if(num_list[i]%2==0){
                divide2++;
            } else{
                nondivide2++;
            }
        }
        int[] answer = {divide2, nondivide2};
        return answer;
    }
}