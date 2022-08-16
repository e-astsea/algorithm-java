import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


public class Main {
    static int l,c;
    static ArrayList<String> al;
    static ArrayList<String> result;
    static int [] checked;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        al = new ArrayList<>();
        checked = new int[c];
        result = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<c; i++){
            al.add(st.nextToken());
        }
        Collections.sort(al);

        dfs(0,0);
    }
    static void dfs(int start,int depth){
        if(depth == l){
            int aeiou=0;
            int not_aeiou=0;
            for(int a=0; a<result.size(); a++){
                String ch = result.get(a);
                switch(ch){
                    case "a":
                        aeiou++;
                        break;
                    case "e":
                        aeiou++;
                        break;
                    case "i":
                        aeiou++;
                        break;
                    case "o":
                        aeiou++;
                        break;
                    case "u":
                        aeiou++;
                        break;
                    default:
                        not_aeiou++;
                        break;
                }
            }
            if(aeiou<1 || not_aeiou<2){
                return;
            }
            for(int j=0; j<result.size();j++){
                System.out.print(result.get(j)+"");
            }
            System.out.println("");
            return;
        }

        for(int i=start; i<al.size(); i++){
            checked[i]=1;
            result.add(al.get(i));
            dfs(i+1,depth+1);
            result.remove(result.size()-1);
            checked[i]=0;
        }
    }
    static void decide(){

    }
}