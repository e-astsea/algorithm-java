import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class pair{
    int x;
    int y;
    pair(int x, int y){
        this.x = x;
        this.y= y;
    }
}
public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int T = Integer.parseInt(str);


        for(int i=0; i<T; i++){
            ArrayList<pair> al = new ArrayList<pair>();
            str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            str=br.readLine();
            st = new StringTokenizer(str);
            for(int j=0; j<N; j++){
                al.add(new pair(j,Integer.parseInt(st.nextToken())));
            }

            int cnt=1;
            while(!al.isEmpty()){

                for(int a=0; a<al.size(); a++){

                    pair tmp = al.get(0);
                    pair ttmp = al.get(a);
                    if(tmp.y < ttmp.y ){
                        al.add(al.get(0));
                        al.remove(0);
                        a=0;
                    }

                }

                if(al.get(0).x == M) {
                    System.out.println(cnt);
                    break;
                }
                else{
                    cnt++;
                    al.remove(0);
                }
            }


        }
    }
}