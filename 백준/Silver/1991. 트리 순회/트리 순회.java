import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static boolean[] checked;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<List<String>> ls = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            ls.add(new ArrayList<>());
        }
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            final String parent = st.nextToken();
            ls.get(parent.charAt(0)-65).add(st.nextToken());
            ls.get(parent.charAt(0)-65).add(st.nextToken());
        }
        preOrder(ls,0);
        System.out.println();
        inOrder(ls,0);
        System.out.println();
        lastOrder(ls,0);
    }

    private static void preOrder(List<List<String>> ls, int start) {
        System.out.print((char)(start+65));
        if(ls.get(start).get(0).charAt(0) != '.'){
            preOrder(ls,ls.get(start).get(0).charAt(0)-65);
        }
        if(ls.get(start).get(1).charAt(0) != '.'){
            preOrder(ls,ls.get(start).get(1).charAt(0)-65);
        }
    }

    private static void inOrder(List<List<String>> ls, int start) {
        if(ls.get(start).get(0).charAt(0) != '.'){
            inOrder(ls,ls.get(start).get(0).charAt(0)-65);
        }
        System.out.print((char)(start+65));
        if(ls.get(start).get(1).charAt(0) != '.'){
            inOrder(ls,ls.get(start).get(1).charAt(0)-65);
        }
    }

    private static void lastOrder(List<List<String>> ls, int start) {
        if(ls.get(start).get(0).charAt(0) != '.'){
            lastOrder(ls,ls.get(start).get(0).charAt(0)-65);
        }
        if(ls.get(start).get(1).charAt(0) != '.'){
            lastOrder(ls,ls.get(start).get(1).charAt(0)-65);
        }
        System.out.print((char)(start+65));
    }
}
