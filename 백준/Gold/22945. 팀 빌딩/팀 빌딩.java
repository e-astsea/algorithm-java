import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        //투포인터에서 현재 변수는 개발자수 + min 값인데, 이 중 하나를 고정시켜야한다.
        //그래서 min값은 고정시켜놓고 개발자수가 계속 줄어들거나, 커지거나 하면된다.
        //커질경우 어디서부터시작해야할지모른다. 줄어드는건 양쪽끝에서.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Integer> ls = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            ls.add(Integer.parseInt(st.nextToken()));
        }

        int start = 0;
        int end = N-1;
        int max = 0;
        while(start<=end){
            max = Math.max(max,(end-start-1)*Math.min(ls.get(start),ls.get(end)));
            if(ls.get(start)<ls.get(end)){
                start++;
            } else {
                end--;
            }
        }
        System.out.println(max);
    }
}
