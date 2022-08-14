import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {
    static int []checked;
    static int N;
    static int M;
    static ArrayList<Integer> result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        checked = new int[N+1];
        result = new ArrayList<>();
        dfs(0);
    }

    public static void dfs(int x){
        if(x==M){

            for(int i=0; i<result.size(); i++){
                System.out.print(result.get(i)+" ");
            }
            System.out.println("");
            return;
        }

        for(int i=1; i<=N; i++) {
            if(checked[i]==1){
                continue;
            }
            if(result.size()>0 && result.get(result.size()-1)>i){
                continue;
            }
            checked[i]=1;
            result.add(i);
            dfs(x+1);
            checked[i]=0;
            result.remove(result.size()-1);
        }
    }
}