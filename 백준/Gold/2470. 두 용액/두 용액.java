import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int []arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int []minus = new int[N];
        int []plus = new int[N];
        int acid =0;
        int al=0;
        int j=0, h=0;
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(st.nextToken());

            if(num<0){
                acid++;
                minus[j++]=num;
            }
            else if(num>0){
                al++;
                plus[h++]=num;
            }
        }
        Arrays.sort(minus);
        Arrays.sort(plus);
        for(int a=0; a<j; a++){
            arr[a]=minus[a];
        }
        for(int b=j; b<j+h; b++){
            arr[b]=plus[b];
        }


        int result =Integer.MAX_VALUE;
        int x=0;
        int y=0;
        if(al==0){
            int k = arr[N-1];
            int right_start = 0;
            int right_end = N-2;

            while(right_start<=right_end){
                //abs가 최소가 될때의 k와 mid값.
                int mid = (right_start+right_end)/2;
                int abs = Math.abs(k+arr[mid]);


                if(k+arr[mid]<0){
                    right_start= mid+1;
                }
                else if(k+arr[mid]>0){
                    right_end=mid-1;
                }
                else{
                    System.out.println(k+" "+arr[mid]);
                    return;
                }

                if(result>=abs) {
                    result = Math.min(abs,result);
                    y=k;
                    x=arr[mid];
                }

            }


            System.out.println(x+" "+y);
            return;
        }

        result =Integer.MAX_VALUE;
        for(int i=0; i<N; i++){
            int k = arr[i];
            int right_start = 0;
            int right_end = N-1;

            while(right_start<=right_end){
                //abs가 최소가 될때의 k와 mid값.
                int mid = (right_start+right_end)/2;
                int abs = Math.abs(k+arr[mid]);


                if(k+arr[mid]<0){
                    right_start= mid+1;
                }
                else if(k+arr[mid]>0){
                    right_end=mid-1;
                }
                else{
                    System.out.println(k+" "+arr[mid]);
                    return;
                }

                if(result>=abs) {
                    if(i==mid){
                        continue;
                    }
                    result = Math.min(abs,result);
                    if(k<arr[mid]) {
                        x = k;
                        y = arr[mid];
                    }
                    else{
                        x=arr[mid];
                        y=k;
                    }
                }

            }
        }
        System.out.println(x+" "+y);

    }
}