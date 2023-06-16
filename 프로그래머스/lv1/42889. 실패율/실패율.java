import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        Map<Integer,Double> ans = new HashMap<>();
        int person = stages.length;
        for(int i=1; i<=N; i++){
            int temp = 0;
            for(int j=0; j<stages.length; j++){
                if(stages[j] == i){
                    temp++;
                }
            }
            if(person ==0){
                ans.put(i,0.0);
                continue;
            }
            ans.put(i, (double)temp/person);

            person -= temp;
        }


        List<Map.Entry<Integer, Double>> entryList = new LinkedList<>(ans.entrySet());
        entryList.sort(new Comparator<Map.Entry<Integer, Double>>() {
            @Override
            public int compare(Map.Entry<Integer, Double> o1, Map.Entry<Integer, Double> o2) {
                if(o1.getValue().equals(o2.getValue())){
                    return o1.getValue().compareTo(o2.getValue());
                }
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        
        for(int i=0; i<entryList.size(); i++){
            answer[i] = entryList.get(i).getKey();
        }


        return answer;
    }
}
