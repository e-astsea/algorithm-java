    import java.io.*;
    import java.util.*;

    public class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            String str = br.readLine();
            int N = Integer.parseInt(str);
            ArrayList<Integer> al = new ArrayList<>();
            ArrayList<Integer> tmp = new ArrayList<>();
            int []arr = new int[8001];
            for(int i=0; i<N; i++){
                str=br.readLine();
                int k =Integer.parseInt(str);
                al.add(k);
                if(k<=0)
                    arr[-1*k]++;
                else
                    arr[k+4000]++;
            }
            Collections.sort(al);
            int max=0;
            int cnt=0;
            for(int i=0; i<8001; i++){
                if(i<=4000)
                    if(arr[max]<=arr[i]){
                        max = i;
                    }
                if(i>4000){
                    if(arr[max]<arr[i]){
                        max = i;
                    }
                }
            }
            cnt = arr[max];
            for(int i=0; i<8001; i++){
                if(arr[i]==cnt){
                    if(i<=4000)
                        tmp.add(-1*i);
                    if(i>4000){
                        tmp.add(i-4000);
                    }
                }
            }
            Collections.sort(tmp);
            int bin=0;
            if(tmp.size()==1){
                bin=tmp.get(0);
            }
            else
                bin=tmp.get(1);



            double mean=0;
            for(int i=0; i<N; i++){
                mean += al.get(i);
            }
            System.out.println((int)Math.round(mean/(double)N));
            System.out.println(al.get(N/2));
            System.out.println(bin);
            System.out.println(al.get(N-1)-al.get(0));
        }

    }