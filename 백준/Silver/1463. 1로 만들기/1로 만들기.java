import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    static long []arr;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int N = Integer.parseInt(str);
        arr = new long[N+1];
        rec(N,0);
        System.out.println(max);
    }
    static int max=Integer.MAX_VALUE;
    public static void rec(int x,int cnt){
        if(x==1){
            if(cnt<max){
                max=cnt;
            }
            return;
        }
        if(cnt>=max){
            return;
        }
        if(x%3 == 0){
            rec(x/3,cnt+1);
        }
        if(x%2 ==0){
            rec(x/2, cnt+1);
        }
            rec(x-1,cnt+1);
    }
}