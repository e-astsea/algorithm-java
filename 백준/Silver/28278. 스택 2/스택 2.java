import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        StringTokenizer st;
        final int num = Integer.parseInt(br.readLine());

        final Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());

            if(first==1){
                stack.push(Integer.parseInt(st.nextToken()));
            }
            if(first==2){
                if(!stack.isEmpty()){
                    sb.append(stack.pop()).append("\n");
                } else{
                    sb.append("-1").append("\n");
                }
            }
            if(first==3){
                sb.append(stack.size()).append("\n");
            }
            if(first==4){
                if(stack.isEmpty()){
                    sb.append("1").append("\n");
                }else{
                    sb.append("0").append("\n");
                }
            }
            if(first==5){
                if (stack.isEmpty()){
                    sb.append("-1").append("\n");
                }else{
                    sb.append(stack.peek()).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}
