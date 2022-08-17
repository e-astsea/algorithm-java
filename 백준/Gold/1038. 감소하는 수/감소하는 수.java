import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


public class Main {
    static long []checked;
    static int N;
    static long M;
    static ArrayList<Integer> result;
    static ArrayList<Long> f;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int input = Integer.parseInt(str);

        N = 9;

        checked = new long[N+1];
        result = new ArrayList<>();
        f = new ArrayList<>();
        for(int i=0; i<=N; i++) {
                dfs(0, 0,N,i);
        }
        Collections.sort(f);
        if(f.size()<=input){
            System.out.println("-1");
        }
        else {
            System.out.println(f.get(input));
        }
    }

    public static void dfs(int x,int start,int N,int M){
        if(x==M+1){
            //Collections.sort(result,Collections.reverseOrder());
            StringBuilder sb = new StringBuilder(100);
            for(int i=result.size()-1; i>=0; i--){
                sb.append(result.get(i));
            }
            long ttmp = Long.parseLong(sb.toString());
            f.add(ttmp);

            return;
        }

        for(int i=start; i<=N; i++) {
            if(checked[i]==1){
                continue;
            }
            checked[i]=1;
            result.add(i);
            dfs(x+1,i+1,N,M);
            checked[i]=0;
            result.remove(result.size()-1);
        }
    }
}