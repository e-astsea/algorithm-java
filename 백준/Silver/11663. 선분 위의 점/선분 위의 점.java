import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] dots = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            dots[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(dots);
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            int result = lower_bound(dots,end) - upper_bound(dots,start);
            System.out.println(result);
        }
    }

    private static int upper_bound(int[] dots, int left) {
        int start = 0;
        int end = dots.length-1;

        while(start<=end){
            int mid = (start+end)/2;

            if(dots[mid]<left){
                start = mid+1;
            } else{
                end = mid-1;
            }
        }

        return start;
    }

    private static int lower_bound(int[] dots, int right) {
        int start = 0;
        int end = dots.length-1;

        while(start<=end){
            int mid = (start+end)/2;

            if(dots[mid] > right){
                end = mid-1;
            } else{
                start = mid+1;
            }
        }

        return end+1;
    }
}
