import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static Set<Integer> set;
    static boolean[] arr = new boolean[1000001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        arr[1] = true;
        for (int i = 2; i < 1000001; i++) {
            for (int j = 2; j*i < 1000001; j++) {
                arr[i*j] = true;
            }
        }
        for (int i = 2; i < N; i++) {
            set = new HashSet<>();
            if(!arr[i] && calc(i,i)){
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb.toString());
    }

    private static boolean calc(int n, int initial) {
        set.add(n);
        int result = 0;
        while(n!=0){
            int num = n % 10;
            result += num*num;
            n/=10;
        }
        if(set.contains(result)){
            return false;
        }
        if(result == 1 && !arr[initial]){
            return true;
        }
        return calc(result,initial);
    }
}
