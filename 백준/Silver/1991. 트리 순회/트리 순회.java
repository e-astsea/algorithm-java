import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int num = Integer.parseInt(br.readLine());

        tree = new int[26][2];

        for (int i = 0; i < num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int parent = st.nextToken().charAt(0) - 65;
            String left = st.nextToken();
            String right = st.nextToken();

            if (left.equals(".")) {
                tree[parent][0] = -1;
            } else{
                tree[parent][0] = left.charAt(0) - 65;
            }

            if (right.equals(".")) {
                tree[parent][1] = -1;
            } else{
                tree[parent][1] = right.charAt(0) - 65;
            }
        }

        preOrder(0);
        System.out.println("");
        inOrder(0);
        System.out.println("");
        lastOrder(0);
    }


    private static void preOrder(final int root) {
        System.out.print((char)(root+65));
        if(tree[root][0] != -1){
            preOrder(tree[root][0]);
        }

        if(tree[root][1] != -1){
            preOrder(tree[root][1]);
        }
    }

    private static void inOrder(final int root) {
        if(tree[root][0] != -1){
            inOrder(tree[root][0]);
        }
        System.out.print((char)(root+65));

        if(tree[root][1] != -1){
            inOrder(tree[root][1]);
        }
    }

    private static void lastOrder(final int root) {
        if(tree[root][0] != -1){
            lastOrder(tree[root][0]);
        }

        if(tree[root][1] != -1){
            lastOrder(tree[root][1]);
        }
        System.out.print((char)(root+65));
    }
}
