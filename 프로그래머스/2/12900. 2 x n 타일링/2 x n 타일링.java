class Solution {
    public int solution(int n) {
        int answer = 0;
        int[] result = new int[n+1];
        result[1] = 1;
        result[2] = 2;
        result[3] = 3;
        for(int i=4; i<n+1; i++){
            result[i]=(result[i-1]+result[i-2])%1000000007;
        }
        
        return result[n];
    }
}