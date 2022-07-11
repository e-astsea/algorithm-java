import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G2437 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int N = Integer.parseInt(str);

        str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int []arr = new int[N];
        int []sum = new int[N];
        for(int i=0; i<N; i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int result=0;
        for(int k=0; k<N; k++){
            if((result+1)<arr[k]){
                break;
            }
            result+=arr[k];
        }
        System.out.println(result+1);
    }


}