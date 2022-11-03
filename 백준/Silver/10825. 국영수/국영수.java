import java.io.*;
import java.util.*;

class pair{
    String name;
    int a;
    int b;
    int c;
    pair(String name,int a, int b, int c) {
        this.name = name;
        this.a = a;
        this.b = b;
        this.c = c;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<pair> al = new ArrayList<>();

        for(int i=0; i<N; i++){
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);
            al.add(new pair(st.nextToken(),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }

        Collections.sort(al,new Comparator<pair>(){
            @Override
            public int compare(pair o1, pair o2) {
                if(o1.a == o2.a){
                    if(o1.b ==o2.b){
                        if(o1.c ==o2.c){
                            return o1.name.compareTo(o2.name);
                        }
                        return o2.c-o1.c;
                    }
                    return o1.b - o2.b;
                }
                return o2.a-o1.a;
            }
        });
        for(int i=0; i<al.size(); i++){
            System.out.println(al.get(i).name);
        }
    }
}
