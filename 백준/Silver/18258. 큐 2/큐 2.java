import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        StringTokenizer st;
        final int num = Integer.parseInt(br.readLine());

        final Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());
            final String str = st.nextToken();

            if(str.equals("push")){
                q.add(Integer.parseInt(st.nextToken()));
            }
            if(str.equals("pop")){
                if(!q.isEmpty()){
                    sb.append(q.poll()).append("\n");
                } else{
                    sb.append("-1").append("\n");
                }
            }
            if(str.equals("size")){
                sb.append(q.size()).append("\n");
            }
            if(str.equals("empty")) {
                if(q.isEmpty()){
                    sb.append("1").append("\n");
                }else{
                    sb.append("0").append("\n");
                }
            }
            if(str.equals("front")){
                if (q.isEmpty()){
                    sb.append("-1").append("\n");
                }else{
                    sb.append(q.peekFirst()).append("\n");
                }
            }
            if(str.equals("back")){
                if (q.isEmpty()){
                    sb.append("-1").append("\n");
                }else{
                    sb.append(q.peekLast()).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}
