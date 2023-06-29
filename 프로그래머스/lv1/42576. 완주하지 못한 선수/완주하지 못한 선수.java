import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap<String,Integer> map = new HashMap<>();
        
        for(int i=0; i<completion.length; i++){
            if(map.containsKey(completion[i])){
                map.put(completion[i], map.get(completion[i])+1);
            }
            else{
                map.put(completion[i],1);   
            }
        }
        for(int j=0; j<participant.length; j++){
            if(!map.containsKey(participant[j]) || map.get(participant[j])==0){
                answer = participant[j];
            }

            if(map.containsKey(participant[j])){
                map.replace(participant[j], map.get(participant[j])-1);
            }
        }
        
        return answer;
    }
}