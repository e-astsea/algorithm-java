import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        List<Integer> ls = new ArrayList<>();

        int[] arr = new int[d+1];
        arr[c] = 1;
        for (int i = 0; i < N; i++) {
            ls.add(Integer.parseInt(br.readLine()));
        }

        int start = 0;
        int end = 0;
        int count = 0;
        int result = 0;
        int check = 1;

        while(start<N) {
            if(count==k){
                result = Math.max(result,check);
            }
            if(count<k){
                if(arr[ls.get(end)]==0){
                    check++;
                }
                arr[ls.get(end)]++;
                end++;
                count++;
            } else{
                int first = arr[ls.get(end)];
                int second = arr[ls.get(start)];

                arr[ls.get(end)]++;
                arr[ls.get(start)]--;

                if(arr[ls.get(end++)]==1 && first == 0){
                    check++;
                }
                if(arr[ls.get(start++)]==0 && second == 1){
                    check--;
                }

                if(end==N){
                    end=0;
                }
            }
        }
        System.out.println(result);
    }
}
