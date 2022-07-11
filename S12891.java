import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S12891 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        String dna = br.readLine();
        char []arrdna = new char[S];
        for(int i=0; i<S; i++){
            arrdna[i]=dna.charAt(i);
        }
        str = br.readLine();
        st = new StringTokenizer(str);
        int A = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int []arr = new int[4];
        for(int i=0; i<P; i++){
            if(arrdna[i]=='A'){
                arr[0]++;
            }
            else if(arrdna[i]=='C'){
                arr[1]++;
            }
            else if(arrdna[i]=='G'){
                arr[2]++;
            }
            else if(arrdna[i]=='T'){
                arr[3]++;
            }
        }
        int end=P-1;
        int count =0;
        if(arr[0]>=A && arr[1]>=C && arr[2]>=G && arr[3]>=T){
            count++;
        }
        for(int i=0; i<S; i++){

            end+=1;
            if(end>=S){
                break;
            }
            if(arrdna[i]=='A'){
                arr[0]--;
            }
            else if(arrdna[i]=='C'){
                arr[1]--;
            }
            else if(arrdna[i]=='G'){
                arr[2]--;
            }
            else if(arrdna[i]=='T'){
                arr[3]--;
            }

            if(arrdna[end]=='A'){
                arr[0]++;
            }
            else if(arrdna[end]=='C'){
                arr[1]++;
            }
            else if(arrdna[end]=='G'){
                arr[2]++;
            }
            else if(arrdna[end]=='T'){
                arr[3]++;
            }

            if(arr[0]>=A && arr[1]>=C && arr[2]>=G && arr[3]>=T){
                count++;
            }
        }
        System.out.println(count);
    }


}