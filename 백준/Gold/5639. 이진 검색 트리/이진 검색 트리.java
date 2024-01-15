import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static class Node{
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }

        public void insert(int num){
            if(this.value > num){
                if(left==null) {
                    left = new Node(num);
                }
                left.insert(num);
            } else if(this.value < num){
                if(right==null) {
                    right = new Node(num);
                }
                right.insert(num);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Node node = new Node(Integer.parseInt(br.readLine()));
        while (true) {
            String input = br.readLine();
            if (input == null || input.equals(""))
                break;
            node.insert(Integer.parseInt(input));
        }

        search(node);
    }

    private static void search(Node node) {
        if(node.left!=null) {
            search(node.left);
        }
        if(node.right!=null) {
            search(node.right);
        }
        System.out.println(node.value);
    }
}
