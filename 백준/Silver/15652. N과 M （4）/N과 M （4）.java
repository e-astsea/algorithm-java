import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {
    static int []checked;
    static int N;
    static int M;
    static BufferedWriter bw;
    static ArrayList<Integer> result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw  = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        checked = new int[N+1];
        result = new ArrayList<>();
        dfs(0);
        bw.flush();
    }

    public static void dfs(int x) throws IOException{

        if(x==M){
            for(int i=0; i<result.size(); i++){
                bw.write(result.get(i)+" ");
            }
            bw.newLine();
            return;
        }

        for(int i=1; i<=N; i++) {
            if(result.size()>0 && result.get(result.size()-1)>i){
                continue;
            }
            result.add(i);
            dfs(x+1);
            result.remove(result.size()-1);
        }
    }
}