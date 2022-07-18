import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    static int N;
    static ArrayList<Integer>[] a;
    static int []checked = new int[100];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        N = Integer.parseInt(str);
        str=br.readLine();
        StringTokenizer st= new StringTokenizer(str);
        int x= Integer.parseInt(st.nextToken());
        int y=Integer.parseInt(st.nextToken());
        str=br.readLine();
        int M=Integer.parseInt(str);
        a= new ArrayList[N+1];
        for(int i=0; i<=N; i++){
            a[i]=new ArrayList<Integer>();
        }
        for(int i=0; i<M; i++){
            str=br.readLine();
            st = new StringTokenizer(str);
            int first = Integer.parseInt(st.nextToken());
            int second =Integer.parseInt(st.nextToken());
            a[first].add(second);
            a[second].add(first);
        }

        dfs(x,y,0);

        if(flag==0){
            System.out.println("-1");
        }
    }

    static int flag=0;
    static void dfs(int x, int y,int depth){
        checked[x]=1;
        if(x==y){
            System.out.println(depth);
            flag=1;
            return;
        }
        for(int i=0; i<a[x].size(); i++){

            if(checked[a[x].get(i)]!=1) {

                dfs(a[x].get(i), y,depth+1);
            }
        }
        checked[x]=0;
    }
}