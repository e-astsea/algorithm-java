import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int N = Integer.parseInt(str);
        int []arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i]=Integer.parseInt(br.readLine());
        }
        int tmp=0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N-1; j++){
                if(arr[j]>arr[j+1]) {
                    tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        for(int i=0; i<N; i++){
            System.out.println(arr[i]);
        }
    }
}