import com.sun.source.tree.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<String,Integer> map = new TreeMap<>();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split("\\.");
            map.put(split[1],map.getOrDefault(split[1],0)+1);
        }

        for (String key:map.keySet()) {
            System.out.println(key+" "+map.get(key));
        }
    }
}
