import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static final int maxSize = 1000001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        boolean[] arr = new boolean[maxSize];

        for (int i = 2; i < maxSize; i++) {
            for (int j = 2; j*i < maxSize; j++) {
                arr[i*j] = true;
            }
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> ls = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            final int value = Integer.parseInt(st.nextToken());
            if(!arr[value]) {
                ls.add(value);
            }
        }

        if(ls.size()==0){
            System.out.println("-1");
            return;
        }

        long n = ls.get(0);
        for (int i = 1; i < ls.size(); i++) {
            n = lcm(n,ls.get(i));
        }
        System.out.println(n);
    }

    private static long lcm(long n, long next) {
        return n*next/gcd(n,next);
    }

    private static long gcd(long n, long next) {
        if(n%next==0){
            return next;
        } else{
            return gcd(next, n%next);
        }
    }
}
