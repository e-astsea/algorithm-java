import java.util.*;

class Solution {
    public static Map<String, List<String>> map = new HashMap<>();
    public static Boolean[] checked;
    public List<String> solution(String[][] tickets) {
        List<String> lsAnswer = new ArrayList<>();
        checked = new Boolean[tickets.length];
        String dep = "ICN";
        lsAnswer.add(dep);
        
        for(int i=0; i<tickets.length; i++){
            if(map.containsKey(tickets[i][0])){
                List<String> value = map.get(tickets[i][0]);
                value.add(tickets[i][1]);
                Collections.sort(value);
                map.put(tickets[i][0], value);
            } else{
                List<String> value = new ArrayList<>();
                value.add(tickets[i][1]);
                map.put(tickets[i][0], value);   
            }
        }
        
        dfs(dep, lsAnswer, tickets.length);
        return lsAnswer;
    }
    
    public boolean dfs(String dep, List<String> answer, int ticketCount){
        if(answer.size() == ticketCount + 1){
            return true;
        }
        
        if(!map.containsKey(dep)){
            return false;
        }
        
        List<String> arr = map.get(dep);
        for(int i=0; i<arr.size(); i++){
            String dest = arr.get(i);
            arr.remove(i);
            answer.add(dest);
            
            if(dfs(dest, answer, ticketCount)){
                return true;
            }
            
            answer.remove(answer.size()-1);
            arr.add(i, dest);
        }
        
        return false;
    }
}
