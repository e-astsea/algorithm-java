import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        List<String> ls = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            ls.add(br.readLine());
        }

        Collections.sort(ls, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() == o2.length()){
                    return o1.compareTo(o2);
                }
                return o1.length() - o2.length();
            }
        });

        ls = ls.stream().distinct().collect(Collectors.toList());

        for (int i = 0; i < ls.size(); i++) {
            System.out.println(ls.get(i));
        }
    }
}
