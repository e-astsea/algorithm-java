import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;



public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int N = Integer.parseInt(str);
        int []arr = new int[N];

        str=br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        str=br.readLine();
        int M = Integer.parseInt(str);
        str = br.readLine();
        st = new StringTokenizer(str);
        for(int i=0; i<M; i++){
            int tmp = Integer.parseInt(st.nextToken());
            int start=0;
            int end=N-1;
            boolean check = false;
            while(start<=end) {
                int mid=(start+end)/2;
                if(arr[mid]>tmp){
                    end=mid-1;
                }
                else if(arr[mid]<tmp){
                    start=mid+1;
                }
                else if(arr[mid]==tmp) {
                        check=true;
                        break;
                }
            }
            if(check==true){
                System.out.println("1");
            }
            else
                System.out.println("0");

        }
    }
}