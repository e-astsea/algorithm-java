import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<String> ls = new ArrayList<>();
        HashMap<Character,Integer> result = new HashMap<>();

        for (int i = 0; i < N; i++) {
            ls.add(br.readLine());
        }

        Comparator<Map.Entry<Character, Integer>> valueComparator = (entry1, entry2) -> {
            int valueCompare = entry2.getValue().compareTo(entry1.getValue()); // 내림차순
            if (valueCompare != 0) {
                return valueCompare;
            } else {
                return entry1.getKey().compareTo(entry2.getKey());
            }
        };

        Character[] answer = new Character[M];
        int ans = 0;
        for (int i = 0; i < M; i++) {
            resultInitialize(result);
            for (int j = 0; j < N; j++) {
                char c = ls.get(j).charAt(i);
                result.put(c,result.get(c)+1);
            }
            List<Map.Entry<Character, Integer>> sortedEntries = new ArrayList<>(result.entrySet());
            sortedEntries.sort(valueComparator);
            answer[i] = sortedEntries.get(0).getKey();
            ans += N-sortedEntries.get(0).getValue();
        }

        for (int i = 0; i < M; i++) {
            System.out.print(answer[i]);
        }
        System.out.println();
        System.out.println(ans);
    }

    private static void resultInitialize(HashMap<Character, Integer> result) {
        result.put('T',0);
        result.put('A',0);
        result.put('G',0);
        result.put('C',0);
    }
}
