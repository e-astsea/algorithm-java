import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb= new StringBuilder();
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        boolean[] arr = new boolean[100000001];
        arr[1]=true;
        for (int i = 2; i <= b; i++) {
            if(!arr[i])
            for (int j = 2; j*i <= b; j++) {
                arr[i*j] = true;
            }
        }

        for (int i = a; i <= b; i++) {
            if(!arr[i]){
                String num = String.valueOf(i);
                int start = 0;
                int end = num.length()-1;
                boolean flag = false;
                while(start<=end){
                    if(num.charAt(start) == num.charAt(end)){
                        start++;
                        end--;
                    } else{
                        flag=true;
                        break;
                    }
                }
                if(!flag){
                    sb.append(num).append("\n");
                }
            }
        }
        sb.append("-1");
        System.out.println(sb.toString());
    }
}
