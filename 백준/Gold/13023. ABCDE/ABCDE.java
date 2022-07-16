import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] A;
    static int []check = new int [2000];
    static int N;
    static int M;
    static int cnt=1;
    static int flag=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A= new ArrayList[N];
        for(int i=0; i<N; i++){
            A[i]=new ArrayList<Integer>();
        }

        for(int i=0; i<M; i++){
            str=br.readLine();
            st = new StringTokenizer(str);

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            A[a].add(b);
            A[b].add(a);
        }

        for(int i=0; i<N; i++){
            cnt=0;
            dfs(i);
        }
        if(flag==0){
            System.out.println("0");
        }
        else
            System.out.println("1");
    }
    static void dfs(int x){
        check[x]=1;
        if(cnt==4){
            flag=1;
            return;
        }
        for(int i=0; i<A[x].size(); i++){
            int a = A[x].get(i);
            if(check[a]!=1) {
                cnt++;
                dfs(a);
                cnt--;
            }
        }
        check[x]=0;
    }
}