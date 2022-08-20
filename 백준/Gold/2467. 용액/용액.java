import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int []arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        int acid =0;
        int al=0;
        for(int i=0; i<N; i++){
            arr[i]=Integer.parseInt(st.nextToken());
            if(arr[i]<0){
                acid=i;
            }
            else if(arr[i]>0){
                al++;
            }
        }
        // 2개다 산성이여도되고 2개다 알칼리여도되고 2개가 섞여도되고 ㅅㅂ;
        // 난 산성만 입력받을땐 산성중에 만 뽑고 알칼리만 입력받을떈 알칼리에서만 뽑고
        // 둘다 될떈 무조건산성+알칼리 로했는데 둘다 일때도 산성만 이거나 알칼리만 일수도있다...ㅅㅂ

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