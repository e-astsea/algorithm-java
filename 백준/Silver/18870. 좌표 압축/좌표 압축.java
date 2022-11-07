import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> al = new ArrayList<>();
        ArrayList<Integer> sorted = new ArrayList<>();
        HashMap<Integer,Integer> sortedAl = new HashMap<Integer,Integer>();
        String str =br.readLine();
        int N = Integer.parseInt(str);
        str= br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        for(int i=0; i<N; i++){
            int a = Integer.parseInt(st.nextToken());
            al.add(a);
            sorted.add(a);
        }
        Collections.sort(sorted,Collections.reverseOrder());

        int count=0;
        for(int i = 0 ; i < sorted.size() ; i++) {
            if(!sortedAl.containsKey(sorted.get(i))) {
                sortedAl.put(sorted.get(i), count++);
            }
        }

        for(int i=0; i<al.size(); i++){
            int tmp = al.get(i);
            sb.append(sortedAl.size()-1-sortedAl.get(tmp)+" ");
        }
        System.out.println(sb);
    }
}
