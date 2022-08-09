import java.io.*;
import java.util.ArrayList;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        int N = str1.length();
        String str2 = br.readLine();
        int M = str2.length();

        int [][] dp = new int[M+2][N+2];
        int [][] dpcheck = new int[M+2][N+2];

        for(int i=1; i<=M; i++){
            for(int j=1; j<=N; j++){
                if( Character.compare(str1.charAt(j-1),str2.charAt(i-1)) == 0 ){
                    dp[i][j] = dp[i-1][j-1]+1;
                    dpcheck[i][j]++;
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }

            }
        }


       ArrayList<Character> al = new ArrayList<>();
       while(true) {
           int tmp = dp[M][N];
           //System.out.println(M+" "+N);
           if (tmp == 0) {
               break;
           }

           if (dp[M - 1][N] != tmp) {
               if (dp[M][N - 1] != tmp) {
                   al.add(str2.charAt(M - 1));
                   M -= 1;
                   N -= 1;
               } else {
                   N -= 1;
               }
           }
           else {
               M-=1;
           }
       }
        System.out.println(al.size());
       for(int i=al.size()-1; i>=0; i--){
           System.out.print(al.get(i));
       }






    }
}