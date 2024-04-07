import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        long sum = 0;

        for(int i =0; i<N; i++){
            int rest = arr[i]-B;
            if(rest>0){
                if(rest%C == 0){
                    sum+=rest/C;
                } else{
                    sum+=rest/C+1;
                }
            }
            sum+=1;
        }

        System.out.println(sum);
    }
}
