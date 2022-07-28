import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    static long []arr;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int T = Integer.parseInt(str);
        for(int i=0; i<T; i++){
            str = br.readLine();
            int a = Integer.parseInt(str);
            cnt=0;
            rec(a);
            System.out.println(cnt);
        }



    }
    static int cnt=0;
    public static void rec(int x){
        if(x==0){
            cnt++;
            return;
        }
        if(x>=3)
            rec(x-3);
        if(x>=2)
            rec(x-2);
        if(x>=1)
            rec(x-1);

    }
}