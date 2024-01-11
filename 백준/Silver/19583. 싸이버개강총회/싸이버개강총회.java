import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        StringTokenizer st2 = new StringTokenizer(st.nextToken(),":");
        Integer startTimeH = Integer.parseInt(st2.nextToken());
        Integer startTimeM = Integer.parseInt(st2.nextToken());
        st2 = new StringTokenizer(st.nextToken(),":");
        Integer endTimeH = Integer.parseInt(st2.nextToken());
        Integer endTimeM = Integer.parseInt(st2.nextToken());
        st2 = new StringTokenizer(st.nextToken(),":");
        Integer lastTimeH = Integer.parseInt(st2.nextToken());
        Integer lastTimeM = Integer.parseInt(st2.nextToken());

        Map<String,Integer> map = new HashMap<>();
        String input = "";
        while((input = br.readLine()) != null && !input.isEmpty()) {
            st = new StringTokenizer(input);
            st2 = new StringTokenizer(st.nextToken(),":");
            Integer hour = Integer.parseInt(st2.nextToken());
            Integer minute = Integer.parseInt(st2.nextToken());
            String name = st.nextToken();

            if((startTimeH==hour&&startTimeM>=minute)||startTimeH>hour){
                map.put(name,0);
            }

            if((endTimeH==hour&&endTimeM<=minute)||endTimeH<hour){
                if((lastTimeH==hour&&lastTimeM>=minute)||lastTimeH>hour){
                    if(map.containsKey(name)){
                        map.put(name,map.get(name)+1);
                    }
                }
            }
        }
        int count = 0;
        for (String key:map.keySet()) {
            if(map.get(key)!=0){
                count++;
            }
        }
        System.out.println(count);
    }

}
