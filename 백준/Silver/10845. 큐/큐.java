import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int N = Integer.parseInt(str);
        Queue<Integer> q = new LinkedList<>();
        int front=-1;
        int rear=-1;
        for(int i=0; i<N; i++){
            str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);
            switch(st.nextToken()){
                case "push" : {
                    rear = Integer.parseInt(st.nextToken());
                    q.add(rear);
                    break;
                }
                case "pop" : {
                    if(q.isEmpty()){
                        System.out.println("-1");
                    }
                    else {
                        int b = q.remove();
                        System.out.println(b);
                    }
                    break;
                }
                case "size" : {
                    System.out.println(q.size());
                    break;
                }
                case "empty" : {
                    if(q.isEmpty()){
                        System.out.println("1");
                    }
                    else{
                        System.out.println("0");
                    }
                    break;
                }
                case "front" :{
                    if(q.isEmpty()){
                        System.out.println("-1");
                    }
                    else
                        System.out.println(q.peek());
                    break;
                }
                case "back" :{
                    if(q.isEmpty()){
                        System.out.println("-1");
                    }
                    else{
                        System.out.println(rear);
                    }
                    break;
                }

            }
        }
    }
}