import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G10986 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);

        String N = st.nextToken();
        String M = st.nextToken();

        str = br.readLine();
        st=new StringTokenizer(str);

        long []sum = new long[Integer.parseInt(N)];
        long []count= new long[Integer.parseInt(M)];


        sum[0]=Integer.parseInt(st.nextToken());
        for(int i=1; i<Integer.parseInt(N);i++){
            sum[i]=sum[i-1]+Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<Integer.parseInt(N);i++){
            sum[i]%=Integer.parseInt(M);
        }

        long result=0;
        for(int i=0; i<Integer.parseInt(N);i++){
            if(sum[i]==0){
                result++;

                count[(int)sum[i]]++;
            }
            else{
                count[(int)sum[i]]++;
            }
        }
        for(int i=0; i<Integer.parseInt(M);i++){
            if(count[i]!=0) {
                result += ((count[i] * (count[i] - 1)) / 2);
            }
        }
        System.out.println(result);





    }

}