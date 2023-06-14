import java.util.*;
class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        List<List<Integer>> new1 = new ArrayList<>();
        List<List<Integer>> new2 = new ArrayList<>();
        List<List<Boolean>> newMap = new ArrayList<>();

        for(int i=0; i<arr1.length; i++){
            new1.add(calc(n,arr1[i]));
        }
        
        for(int i=0; i<arr2.length; i++){
            new2.add(calc(n,arr2[i]));
        }
        
        for(int j=0; j<n; j++){
            String map = "";
            for (int k=0; k<n; k++){
                if((new1.get(j).get(k) == 0) && (new2.get(j).get(k) == 0)){
                    map= map+" ";
                }
                else{
                    map = map+"#";
                }
            }
            answer[j] = map;
        }
        
        return answer;
    }
    
    public List<Integer> calc(int n, int num){
        List<Integer> temp = new ArrayList<>();
        while(num>0){
            int tmp = num%2;
            num/=2;
            temp.add(tmp);
        }
        
        while(temp.size() != n){
            temp.add(0);
        }
        
        Collections.reverse(temp);
        return temp;
    }
}