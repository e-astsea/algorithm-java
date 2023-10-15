import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        StringTokenizer st;
        final int num = Integer.parseInt(br.readLine());

        final Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());

            if(first==1){
                deque.addFirst(Integer.parseInt(st.nextToken()));
            }
            if(first==2){
                deque.addLast(Integer.parseInt(st.nextToken()));
            }
            if(first==3){
                if(!deque.isEmpty()){
                    sb.append(deque.pollFirst()).append("\n");
                } else{
                    sb.append("-1").append("\n");
                }
            }
            if(first==4){
                if(!deque.isEmpty()){
                    sb.append(deque.pollLast()).append("\n");
                } else{
                    sb.append("-1").append("\n");
                }
            }
            if(first==5){
                sb.append(deque.size()).append("\n");
            }
            if(first==6){
                if(deque.isEmpty()){
                    sb.append("1").append("\n");
                }else{
                    sb.append("0").append("\n");
                }
            }
            if(first==7){
                if (deque.isEmpty()){
                    sb.append("-1").append("\n");
                }else{
                    sb.append(deque.peekFirst()).append("\n");
                }
            }
            if(first==8){
                if (deque.isEmpty()){
                    sb.append("-1").append("\n");
                }else{
                    sb.append(deque.peekLast()).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}
