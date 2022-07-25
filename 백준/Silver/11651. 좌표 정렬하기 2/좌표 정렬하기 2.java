import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class pair implements Comparable<pair>{
    int x;
    int y;
    pair(int x, int y){

        this.x = x;
        this.y = y;
    }
    @Override
    public int compareTo(pair p){
        if(this.y>p.y){
            return 1;
        }
        else if(this.y==p.y) {
            if(this.x>p.x){
                return 1;
            }
        }
        return -1;
    }

}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int N = Integer.parseInt(str);
        ArrayList<pair> al = new ArrayList<>();
        for(int i=0; i<N; i++){
            str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);
            al.add(new pair(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }
        Collections.sort(al);
        for(int i=0; i<al.size(); i++){
            pair p = al.get(i);
            System.out.println(p.x+" "+p.y);
        }
    }
}