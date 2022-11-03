import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        ArrayList<Integer> al = new ArrayList<>();
        for(int i=0; i<N; i++){
            al.add(Integer.parseInt(st.nextToken()));
        }
        int v = Integer.parseInt(br.readLine());
        int result=0;
        for(int i=0; i<N; i++) {
            if(al.get(i) == v)
                result++;
        }
        System.out.println(result);
    }
}
