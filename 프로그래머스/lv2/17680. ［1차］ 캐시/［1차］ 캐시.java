import java.util.*;


class Solution {
    public int solution(int cacheSize, String[] cities) {
        ArrayList<String> al = new ArrayList<>();
        int answer = 0;
        
        for(int i=0; i<cities.length; i++){
            if(al.size()<cacheSize || cacheSize==0){
                if(al.contains(cities[i].toLowerCase())&&cacheSize!=0){
                    al.remove(al.indexOf(cities[i].toLowerCase()));
                    al.add(cities[i].toLowerCase());
                    answer+=1;   
                }
                else{
                    al.add(cities[i].toLowerCase());        
                    answer+=5;
                }
            }
            else{
                if(al.contains(cities[i].toLowerCase())){
                    al.remove(al.indexOf(cities[i].toLowerCase()));
                    al.add(cities[i].toLowerCase());
                    answer+=1;
                }
                else{
                    al.remove(0);
                    al.add(cities[i].toLowerCase());
                    answer+=5;
                }
            }
            
        }
        
        return answer;
    }
} 