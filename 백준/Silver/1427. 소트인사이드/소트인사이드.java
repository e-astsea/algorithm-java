import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int N = Integer.parseInt(str);
        int max=0;
        int maxcnt=0;
        int []arr = new int[str.length()];
        for(int i=0; i<str.length();i++){
            arr[i]=str.charAt(i)-'0';
        }
        for(int i=0; i<str.length();i++){
            max=0;
            for(int j=i; j<str.length(); j++){
                if(arr[j]>max){
                    max=arr[j];
                    maxcnt=j;
                }
            }
            if(arr[i]<max){
                int tmp=arr[i];
                arr[i]=arr[maxcnt];
                arr[maxcnt]=tmp;
            }
        }

        for(int i=0; i<str.length();i++){
            System.out.print(arr[i]);
        }

    }
}