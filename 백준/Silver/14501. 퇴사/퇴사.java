import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class pair{
    int t;
    int p;
    pair(int t, int p){
        this.t = t;
        this.p =p;
    }
}
public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int N = Integer.parseInt(str);
        ArrayList<pair> al = new ArrayList<>();
        int []arr=new int[N+1];
        for(int i=0; i<N; i++){
        str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int t = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        al.add(new pair(t,p));
        }

        for(int i=N-1; i>=0; i--){
            pair tmp = al.remove(i);
            if(i+tmp.t>N){
                arr[i]=arr[i+1];
            }
            else {
                arr[i]=Math.max(arr[i+1],tmp.p+arr[i+tmp.t]);
            }
        }
        System.out.println(arr[0]);
    }
}