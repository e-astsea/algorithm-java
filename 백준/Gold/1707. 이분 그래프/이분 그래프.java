import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int []checked;
    static ArrayList<Integer>[] al;
    static int []binary;
    static int flag=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int N = Integer.parseInt(str);
        for(int i=0; i<N; i++){
            checked = new int[20001];
            al=new ArrayList[20001];
            binary = new int[20001];
            str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            for(int a=0; a<20001; a++)
                al[a] = new ArrayList<Integer>();
            for(int j=0; j<E; j++) {
                str = br.readLine();
                st = new StringTokenizer(str);
                int first = Integer.parseInt(st.nextToken());
                int second = Integer.parseInt(st.nextToken());
                al[first].add(second);
                al[second].add(first);
            }
            flag=0;
            for(int k=1; k<=V; k++){
                if(checked[k]!=1)
                    dfs(k,1);
            }
            if(flag==1){
                System.out.println("NO");
            }
            else
                System.out.println("YES");
        }

    }
    static void dfs(int x,int b){
        binary[x]=b;
        checked[x]=1;
        int newb=0;
        if(b==1){
            newb=2;
        }
        else if(b==2){
            newb=1;
        }
        for(int i=0; i<al[x].size(); i++){
            int m = al[x].get(i);
            if(binary[m]>0 && binary[m] == b){
                flag=1;
                return;
            }
            if(checked[m]!=1)
                dfs(m, newb);
        }
    }
}