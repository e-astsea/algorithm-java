import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S2018 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int N = Integer.parseInt(str);
        int start=0;
        int end =0;
        int sum=0;
        int count =0;
        while(end!=(N+1)){
            if(sum<N){
                end++;
                sum+=end;
            }
            else if(sum>N){
                sum-=start;
                start++;
            }
            else if(sum==N){
                count++;
                end++;
                sum+=end;
            }
        }
        System.out.println(count);




    }

}