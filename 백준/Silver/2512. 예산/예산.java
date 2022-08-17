import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int N = Integer.parseInt(str);
        int []arr = new int[N];

        str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        for(int i=0; i<N; i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        str = br.readLine();
        int M = Integer.parseInt(str);

        int start =0;
        int end = M;
        //int mid = (start+end)/2;
        int f=0;
        while(start<=end){
            int result=0;
            int mid = (start+end)/2;

            for(int i=0;i<N; i++){
                if(arr[i]<=mid){
                    result+=arr[i];
                }
                else if(arr[i]>mid){
                    result+=mid;
                }
            }

            if(result>M){
                end=mid-1;
            }
            else{
                start = mid+1;
                f = Math.max(f,mid);
            }
        }
        if(f>arr[N-1]){
            System.out.println(arr[N-1]);
        }
        else {
            System.out.println(f);
        }
    }
}