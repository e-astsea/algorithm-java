    import java.io.*;
    import java.util.*;

    public class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int []arr = new int[N+1];

            for(int i=1; i<=N;i++){
                arr[i]=i;
            }
            arr[1]=0;
            for(int i=2; i<=N; i++){
                if(arr[i]==0){
                    continue;
                }
                for(int j=i+i; j<=N; j+=i){
                    arr[j]=0;
                }
            }

            for(int i=M;i<=N;i++){
                if(arr[i]!=0)
                System.out.println(arr[i]);
            }
        }

    }