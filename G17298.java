import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class G17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        String str = br.readLine();
        int N = Integer.parseInt(str);
        str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        int []arr = new int[N];
        int []ans = new int[N];

        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<N; i++){
            arr[i]=(Integer.parseInt(st.nextToken()));
        }

        stack.push(0);
        for(int i=1; i<N; i++){
            while(!stack.isEmpty() && arr[stack.peek()]<arr[i]){
                int b =stack.pop();
                ans[b]=arr[i];
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int a = stack.pop();
            ans[a]=-1;
        }
        for(int i=0; i<N; i++){
            System.out.print(ans[i]+" ");
        }

    }
}