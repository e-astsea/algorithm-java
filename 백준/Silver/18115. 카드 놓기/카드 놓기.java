import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Integer> ls = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            ls.add(Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < N; i++) {
            final Integer command = ls.get(N-i-1);
            if(command==1){
                deque.addFirst(i+1);
            } else if(command==2){
                final Integer tmp = deque.poll();
                deque.addFirst(i+1);
                deque.addFirst(tmp);
            } else if(command==3){
                deque.addLast(i+1);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!deque.isEmpty()){
            sb.append(deque.poll()).append(" ");
        }
        System.out.println(sb.toString());
    }
    //1번을 썼다면 맨앞에 삽입
    //2번을 썼다면 맨앞에서 두번쨰에
    //3번을 썼다면 맨뒤에 삽

}
