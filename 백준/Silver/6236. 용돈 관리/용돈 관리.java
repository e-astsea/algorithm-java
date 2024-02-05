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
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer> ls = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < N; i++) {
            int money = Integer.parseInt(br.readLine());
            ls.add(money);
            max =Math.max(money,max);
        }

        int start = max;
        int end = 10000*100000;
        int result = 0;
        while(start<=end){
            int mid = (start+end)/2;

            int count = 1;
            int tmp = mid;
            for (int i = 0; i < N; i++) {
                int money = ls.get(i);
                if(tmp>=money){
                    tmp-=money;
                } else{
                    count++;
                    tmp=mid-money;
                }
            }

            if(count<=M){
                end = mid-1;
                result = mid;
            } else{
                start = mid+1;
            }
        }

        System.out.println(result);
    }
}
