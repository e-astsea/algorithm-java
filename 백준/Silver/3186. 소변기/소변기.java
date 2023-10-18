import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        //K초 이상 소변기 앞에 있을 경우 사용중
        //L초 이상 비어있을 경우 물뿌린다.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        String str = br.readLine();
        for (int i = N; i < L+N; i++) {
            str = str.concat("0");
        }
        int connect = 0;
        int before = 0;
        List<Integer> ls = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            final char c = str.charAt(i);
            if(c == '1'){
                connect+=1;
            } else{
                connect = 0;
            }

            if(connect == K){
                int empty = L;
                int index = i;
                while(true){
                    if(str.charAt(index++)== '0'){
                        empty--;
                    } else{
                        empty = L;
                    }
                    if(empty==0){
                        break;
                    }
                }
                i=index-1;
                ls.add(index);
                connect=0;
            }
        }

        if(ls.size() == 0){
            System.out.println("NIKAD");
            return;
        }
        for (int i = 0; i < ls.size(); i++) {
            System.out.println(ls.get(i));
        }
    }
}
