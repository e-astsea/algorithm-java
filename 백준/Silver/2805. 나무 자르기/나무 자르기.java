import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);

        int N = Integer.parseInt(st.nextToken());
        long M = Integer.parseInt(st.nextToken());
        int [] arr = new int[N+1];

        str = br.readLine();
        st = new StringTokenizer(str);

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        //1 10000000000
        long start=0;
        long end = 1000000001;

        long max=0;
        while(start<=end){

            long result = 0;
            long mid = (start+end)/2;

            for(int j=0; j<N; j++){
                if(arr[j]-mid>0)
                    result+= arr[j]-mid;
            }

            if(result >= M){
                if(result>=M)
                max = Math.max(max,mid);
                start=mid+1;
            }

            else if(result<M){
                end=mid-1;
            }

        }
        System.out.println(max);


    }
}