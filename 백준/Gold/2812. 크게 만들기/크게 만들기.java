import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int N =Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        str = br.readLine();
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i=0;i<N;i++){
            if(K==0){
                dq.addFirst(str.charAt(i)-'0');
                continue;
            }
            if(i==0){
                dq.addFirst(str.charAt(i)-'0');
                continue;
            }
            while(!dq.isEmpty()&&dq.getFirst()<str.charAt(i)-'0'){
                dq.removeFirst();
                K--;
                if(K==0){
                    break;
                }
                if(dq.isEmpty()){
                    break;
                }

            }
            dq.addFirst(str.charAt(i)-'0');
        }
        if(K!=0){
            while(true){
                dq.removeFirst();
                K--;
                if(K==0){
                    break;
                }

            }
        }
        while(!dq.isEmpty()){
            System.out.print(dq.pollLast());
        }


    }
}