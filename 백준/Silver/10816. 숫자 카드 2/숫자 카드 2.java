import java.io.*;
import java.util.*;



public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        int N = Integer.parseInt(str);
        int []arr = new int[N];
        int []arr2 = new int[20000002];
        str=br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if(arr[i]<0) {
                arr2[-1*arr[i]]++;
            }
            else
                arr2[arr[i]+10000000]++;
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
                if(tmp<0){
                    bw.append(arr2[-1*tmp]+" ");
                }
                else
                    bw.append(arr2[tmp+10000000]+" ");
            }
            else
                bw.append("0 ");
        }
        bw.flush();
    }
}