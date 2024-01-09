import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {
            LinkedList<Character> ls = new LinkedList<>();
            String str = br.readLine();
            ListIterator<Character> iterator = ls.listIterator();
            for (int j = 0; j < str.length(); j++) {
                final char now = str.charAt(j);
                if(now == '<'){
                    if(iterator.hasPrevious()) {
                        iterator.previous();
                    }
                } else if(now =='>'){
                    if(iterator.hasNext()){
                        iterator.next();
                    }
                } else if(now == '-') {
                    if(iterator.hasPrevious()) {
                        iterator.previous();
                        iterator.remove();
                    }
                }
                else{
                    iterator.add(now);
                }
            }

            StringBuilder sb = new StringBuilder();
            for (final Character l : ls) {
                sb.append(l);
            }
            System.out.println(sb.toString());
        }
    }
}
