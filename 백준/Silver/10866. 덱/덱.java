import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int N = Integer.parseInt(str);
        Deque<Integer> de = new ArrayDeque<>();

        for(int i=0; i<N; i++){
            str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);
            int tmp=0;
            switch (st.nextToken()){
                case "push_front":
                    tmp= Integer.parseInt(st.nextToken());
                    de.addFirst(tmp);
                    break;
                case "push_back":
                    tmp = Integer.parseInt(st.nextToken());
                    de.addLast(tmp);
                    break;
                case "pop_front":
                    if(de.isEmpty()){
                        System.out.println("-1");
                        break;
                    }
                    tmp = de.removeFirst();
                    System.out.println(tmp);
                    break;
                case "pop_back":
                    if(de.isEmpty()){
                        System.out.println("-1");
                        break;
                    }
                    tmp = de.removeLast();
                    System.out.println(tmp);
                    break;
                case "size":
                    System.out.println(de.size());
                    break;
                case "empty":
                    if(de.isEmpty()){
                        System.out.println("1");
                    }
                    else{
                        System.out.println("0");
                    }
                    break;
                case "front":
                    if(de.isEmpty()){
                        System.out.println("-1");
                        break;
                    }
                    System.out.println(de.peekFirst());
                    break;
                case "back":
                    if(de.isEmpty()){
                        System.out.println("-1");
                        break;
                    }
                    System.out.println(de.peekLast());
                    break;
            }
        }
    }
}