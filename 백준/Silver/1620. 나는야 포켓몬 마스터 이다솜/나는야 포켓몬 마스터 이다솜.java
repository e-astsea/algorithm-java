import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<Integer,String> indexMap = new HashMap<>();
        Map<String,Integer> valueMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            final String str = br.readLine();
            indexMap.put(i,str);
            valueMap.put(str,i);
        }

        for (int i = 0; i < M; i++) {
            final String str = br.readLine();
            try{
                final int index = Integer.parseInt(str)-1;
                System.out.println(indexMap.get(index));
            } catch(NumberFormatException nfe) {
                System.out.println(valueMap.get(str)+1);
            }
        }
    }
}
