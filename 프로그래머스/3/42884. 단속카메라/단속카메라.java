import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes,(o1,o2)-> o1[1] - o2[1]);
                
        boolean flag = false;
        int tmp = -1;
        for(int i=0; i<routes.length;i++){
            if(!flag){
                tmp = routes[i][1];
                answer++;
                flag=true;
            } else{
                if(routes[i][0] <= tmp){
                    continue;
                } else{
                    tmp=-1;
                    flag = false;
                    i--;
                }
            }
        }
        return answer;
    }
}