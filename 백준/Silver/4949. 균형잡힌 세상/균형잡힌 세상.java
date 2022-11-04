import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();

        while(true) {
            String str = br.readLine();
            boolean flag=true;
            if(str.equals(".")){
                break;
            }

            for(int i=0; i<str.length()-1; i++){
                if(str.charAt(i)=='('){
                    stack.push(str.charAt(i));
                }
                else if(str.charAt(i)==')'){
                    if(stack.isEmpty()){
                        flag=false;
                        break;
                    }
                    if(stack.peek()!='('){
                        flag=false;
                        break;
                    }
                    else
                        stack.pop();
                }
                if(str.charAt(i)=='['){
                    stack.push(str.charAt(i));
                }
                else if(str.charAt(i)==']'){
                    if(stack.isEmpty()){
                        flag=false;
                        break;
                    }
                    if(stack.peek()!='['){
                        flag=false;
                        break;
                    }
                    else
                        stack.pop();
                }
            }

            if(!stack.isEmpty()){
                flag=false;
            }
            if(flag){
                System.out.println("yes");
            }
            else
                System.out.println("no");
            stack.clear();
        }

    }

}