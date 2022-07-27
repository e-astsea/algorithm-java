    import java.io.*;
    import java.util.*;

    public class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            String str = br.readLine();
            int N = Integer.parseInt(str);
            int []arr = new int[2000001];
            ArrayList<Integer> al = new ArrayList<>();

            for(int i=1; i<=2000000;i++){
                arr[i]=i;
            }
            arr[1]=0;
            for(int i=1; i<=2000000; i++){
                if(arr[i]==0){
                    continue;
                }
                al.add(i);
                for(int j=i+i; j<=2000000; j+=i){
                    arr[j]=0;
                }
            }

            for(int i=0; i<al.size(); i++){
                if(al.get(i)<N)
                    continue;
                String st = Integer.toString(al.get(i));
                int start=0;
                int end=st.length()-1;
                for(int j=0; j<=(st.length()-1)/2; j++){
                    if(st.charAt(start)==st.charAt(end)){

                        start++;
                        end--;
                        if(start>=end){
                            System.out.println(st);
                            return;
                        }
                    }
                    else{
                        break;
                    }
                }
            }
        }
    }