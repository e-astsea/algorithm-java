import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        long X =Integer.parseInt(st.nextToken());
        long Y =Integer.parseInt(st.nextToken());


        double first = (int)Math.floor(((double)100*Y/X));
        if(first>=99){
            System.out.println("-1");
            return;
        }
        double minus = X-Y;
        long start = 0;
        long end = Integer.MAX_VALUE;
        long result=Integer.MAX_VALUE;
        int flag=0;
        while(start<=end){
            long mid = (start+end)/2;
            int probability = (int)Math.floor(((Y + (double) mid) * 100 / (X + (double) mid)));
            //System.out.println(probability+" "+start+" "+mid+" "+end);

            if(probability<=first){
                start = mid+1;
            }
            else{
                end=mid-1;
            }

                result = start;

        }

            System.out.println(result);
    }
}