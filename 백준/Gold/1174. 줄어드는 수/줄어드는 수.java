import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = {9,8,7,6,5,4,3,2,1,0};
        ls = new ArrayList<>();
        dfs(arr,0,0L);
        Collections.sort(ls);
        if(ls.size()<N){
            System.out.println("-1");
        } else {
            System.out.println(ls.get(N - 1));
        }
    }
    static List<Long> ls;
    private static void dfs(int[] arr,int index,Long result) {
        if(index>=10){
            if(!ls.contains(result)) {
                ls.add(result);
            }
            return;
        }
        int num = arr[index];

        for (int i = index; i <arr.length; i++) {
            dfs(arr,i+1,result*10+num);
            dfs(arr,i+1,result);
        }
    }
}
