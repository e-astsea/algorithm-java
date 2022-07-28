import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    static int []arr;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int T = Integer.parseInt(str);
        for(int i=0; i<T; i++){
            str = br.readLine();
            int a = Integer.parseInt(str);
            arr= new int[a+1];
            arr[0]=0;
            if(a>0)
            arr[1]=1;
            fib(a);
            if(a>0)
            System.out.println(arr[a-1]+" "+arr[a]);
            else
                System.out.println("1 0");
        }



    }

    public static void fib(int x){

        for(int i=2; i<=x; i++){
            arr[i]=arr[i-1]+arr[i-2];
        }

    }
}