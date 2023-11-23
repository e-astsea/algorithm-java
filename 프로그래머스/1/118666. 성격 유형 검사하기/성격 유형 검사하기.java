import java.util.HashMap;
import java.util.Map;

class Solution {
        public String solution(String[] survey, int[] choices) {
        String answer = "";
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < survey.length; i++) {
            char first = survey[i].charAt(0);
            char second = survey[i].charAt(1);

            if(choices[i]==1){
                map.put(first,map.getOrDefault(first,0)+3);
            } else if(choices[i]==2){
                map.put(first,map.getOrDefault(first,0)+2);
            } else if(choices[i]==3){
                map.put(first,map.getOrDefault(first,0)+1);
            }else if(choices[i]==5){
                map.put(second,map.getOrDefault(second,0)+1);
            }else if(choices[i]==6){
                map.put(second,map.getOrDefault(second,0)+2);
            }else if(choices[i]==7){
                map.put(second,map.getOrDefault(second,0)+3);
            }
            
        System.out.println(first +" "+map.getOrDefault(first,0));
        System.out.println(second +" "+map.getOrDefault(second,0));
        }

        StringBuffer sb = new StringBuffer();
        method(map, 'R', 'T', sb);
        method(map, 'C', 'F', sb);
        method(map, 'J', 'M', sb);
        method(map, 'A', 'N', sb);

        return sb.toString();
    }

    private static void method(Map<Character, Integer> map, char R, char T, StringBuffer sb) {

        if (map.getOrDefault(R,0) > map.getOrDefault(R,0)) {
            sb.append(R);
        } else if (map.getOrDefault(R,0) < map.getOrDefault(T,0)) {
            sb.append(T);
        } else {
            sb.append(R);
        }
    }
}
