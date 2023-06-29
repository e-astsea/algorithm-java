class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int maxHori = 0;
        int maxVer = 0;
        
        for(int i=0; i<sizes.length; i++){
            if(sizes[i][0] >= sizes[i][1]){
                maxHori = Math.max(maxHori, sizes[i][0]);
                maxVer = Math.max(maxVer, sizes[i][1]); 
            } else if(sizes[i][0] < sizes[i][1]){
                maxHori = Math.max(maxHori, sizes[i][1]);
                maxVer = Math.max(maxVer, sizes[i][0]); 
            }
        }
        return maxHori * maxVer;
    }
}