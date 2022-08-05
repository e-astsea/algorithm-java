import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int max=0;
        int []arr = new int[N];
        for(int i=0; i<K; i++){
            str = br.readLine();
            arr[i]=Integer.parseInt(str);
        }

        long start = 1;
        long last=(long)Integer.MAX_VALUE+1;

        long tmp;
        while(true){

            int result=0;
            long mid=(start+last)/2;

            if(start>=mid || mid>=last){
                System.out.println(mid);
                break;
            }

            for(int j=0; j<K; j++){
                result += arr[j]/mid;
            }
            if(result<N){
                last=mid;
            }
            else
                start=mid;

            if(result==(N)){
                start=mid;
                //System.out.println(start+" "+mid+" "+last);
            }
        }

       /* while(true){
            int result=0;
            tmp++;
            for(int j=0; j<K; j++){
                result += arr[j]/tmp;
            }
            if(result==(N-1)){
                System.out.println(tmp-1);
                break;
            }
        }*/



    }
}