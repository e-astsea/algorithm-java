import java.util.*;
class Solution {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        
        int Aindex = 0;
        int Bindex = 0;
        
        int answer = 0;
        while(Bindex<B.length){
            if(A[Aindex] < B[Bindex]){
                answer++;
                Aindex++;
                Bindex++;
            } else{
                Bindex++;
            }
        }
        
        return answer;
    }
}