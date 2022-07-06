
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Stack;
import java.util.StringTokenizer;

public class S9012 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Stack<Character> stack = new Stack<>();

        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++) {
            String str = br.readLine();
            for(int j=0; j<str.length(); j++){
                stack.push(str.charAt(j));
            }
            int left=0;
            for(int k=0; k<str.length(); k++){
                char a = stack.pop();
                if(a==')'){
                    left++;
                }
                else if(a=='('){
                    left--;
                }

                if(left<0 || (stack.isEmpty() && left!=0)){
                    System.out.println("NO");
                    break;
                }
                else if(left ==0 && stack.isEmpty()){
                    System.out.println("YES");
                    break;
                }
            }
            stack.clear();
        }


    }

}