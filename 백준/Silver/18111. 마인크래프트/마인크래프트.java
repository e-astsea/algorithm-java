import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N+1][M+1];
        int[][] tmp = new int[N+1][M+1];

        for (int i = 0; i < N; i++) {
            str = br.readLine();
            st = new StringTokenizer(str);
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int result=Integer.MAX_VALUE;
        int result_index=0;
        //2가지로 나누어서. 최소~최대까지 추가하면서, 최대~최소까지 줄여가면서서
        for (int i = 0; i <= 256; i++) {
            int time =0;
            int flag=0;
            int tmpB = B;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                        if (arr[j][k] < i) {
                            int temp = i-arr[j][k];
                            tmpB-=temp;
                            time+=1*temp;
                        } else if (arr[j][k] > i) {
                            int tp = arr[j][k]-i;
                            tmpB+=tp;
                            time+=2*tp;
                        }
                }
            }
            if(tmpB>=0) {
                if(result>time) {
                    result = Math.min(result, time);
                    result_index=i;
                }
                else if(result==time){
                    if(result_index<i){
                        result = Math.min(result, time);
                        result_index=i;
                    }
                }
            }

        }
        System.out.println(result+" "+result_index);
    }
}