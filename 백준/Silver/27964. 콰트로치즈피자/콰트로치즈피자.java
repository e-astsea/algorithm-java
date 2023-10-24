import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        final String str = br.readLine();
        final StringTokenizer st = new StringTokenizer(str);
        final ArrayList<String> ls = new ArrayList<>();
        for (int i = 0; i <N; i++) {
            ls.add(st.nextToken());
        }

        String cheese = "Cheese";
        Set<String> set = new HashSet<>();
        for (int i = 0; i < ls.size(); i++) {
            final String topping = ls.get(i);
            if(topping.contains(cheese) && topping.substring(topping.length() - cheese.length(),topping.length()).equals(cheese)){
                set.add(topping);
            }
        }
        if(set.size() >= 4){
            System.out.println("yummy");
        } else{
            System.out.println("sad");
        }
    }
}
