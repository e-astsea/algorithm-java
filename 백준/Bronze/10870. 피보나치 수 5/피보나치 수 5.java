import java.io.*;

public class Main {
    public static int result=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());


        System.out.println(func(N));
    }
    public static int func(int N){
        if(N==1){
            return 1;
        }
        if(N==0){
            return 0;
        }

        return func(N-1)+func(N-2);
    }
}