import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class pair implements Comparable<pair>{
    int num;
    String name;
    pair(int num, String name){
        this.num = num;
        this.name = name;
    }
    @Override
    public int compareTo(pair p){
        if(this.num>p.num){
            return 1;
        }
        else if(this.num<p.num){
            return -1;
        }
        else{
            return 0;
        }
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
            al.add(new pair(Integer.parseInt(st.nextToken()),st.nextToken()));
        }
        Collections.sort(al);
        for(int i=0; i<al.size(); i++){
            pair p = al.get(i);
            System.out.println(p.num+" "+p.name);
        }
    }
}