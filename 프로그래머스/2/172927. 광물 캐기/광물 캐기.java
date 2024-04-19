class Solution {
    static int[][] map = {{1,1,1},{5,1,1},{25,5,1}};
    
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        
        find(picks,minerals,0,0,0);
        return ans;
    }
    static int ans = Integer.MAX_VALUE;
    
    public void find(int[] picks, String[] minerals, int num, int result, int nextIdx){
        //곡갱이 개수 다 닳거나
        int gokNum = 0;
        for(int i=0; i<3; i++){
            gokNum+=picks[i];
        }
        if(gokNum == 0){
            ans = Math.min(result,ans);
            return;
        }
        //자원 다캐거나
        if(nextIdx>=minerals.length){
            ans = Math.min(result,ans);
            return;
        }
        
        for(int i=0; i<3; i++){
            if(picks[i] == 0){
                continue;
            }
            int re = 0;
            int tmp = nextIdx;
            for(int j=0; j<Math.min(5,minerals.length - tmp); j++){
                int idx = -1;
                if(minerals[nextIdx].equals("diamond")){
                    idx = 0;
                } else if(minerals[nextIdx].equals("iron")){
                    idx = 1;
                } else{
                    idx = 2;
                }
                re += map[i][idx];
                nextIdx++;
            }
            
            picks[i]--;
            find(picks,minerals,i, result+re ,nextIdx);
            nextIdx = tmp;
            picks[i]++;
        }
    }
}