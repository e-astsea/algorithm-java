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
        int []arr2 = new int[M];
        str = br.readLine();
        st = new StringTokenizer(str);
        for(int i=0; i<M; i++){
            arr2[i]=Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<M; i++){
            int k = arr2[i];

            int start = 0;
            int end = N-1;

            int flag =0;
            while(start<=end){
                int mid = (start+end)/2;

                if(k<arr[mid]){
                    end = mid-1;
                }
                else if(k>arr[mid]){
                    start=mid+1;
                }
                else if(k==arr[mid] && flag==0){
                    System.out.print("1 ");
                    flag=1;
                }
                else {
                    break;
                }
            }

            if(flag==0){
                System.out.print("0 ");
            }

        }



    }
}