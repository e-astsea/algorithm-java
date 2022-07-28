import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class pair{
    int x;
    int y;
    pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class Main{
    static ArrayList<pair> al=new ArrayList<>();
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int T = Integer.parseInt(str);

        for(int i=0; i<T; i++) {
            str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);
            int weight = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            al.add(new pair(weight, height));

        }

        for(int i=0; i<T; i++){
            int cnt=1;
            int ox = al.get(i).x;
            int oy = al.get(i).y;
            for(int j=0; j<T; j++){
                int nx = al.get(j).x;
                int ny = al.get(j).y;
                if(i==j)
                    continue;

                if(nx>ox && ny>oy){
                    cnt++;
                }
            }
            System.out.print(cnt+" ");
        }



    }
}