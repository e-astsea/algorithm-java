import java.io.*;
import java.lang.reflect.Array;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        int N = Integer.parseInt(str);
        ArrayList<Integer> al = new ArrayList<>();
        for(int i=0; i<N; i++){
            str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);
            String command = st.nextToken();
            int num;

            switch (command) {
                case "add" :
                    num = Integer.parseInt(st.nextToken());
                    if(!al.contains(num))
                        al.add(num);
                    break;
                case "remove" :
                    num = Integer.parseInt(st.nextToken());
                    if(al.contains(num))
                        al.remove(Integer.valueOf(num));
                    break;
                case "check" :
                    num = Integer.parseInt(st.nextToken());
                    if(al.contains(num)){
                        bw.write("1\n");
                    }
                    else
                        bw.write("0\n");
                    break;
                case "toggle" :
                    num = Integer.parseInt(st.nextToken());
                    if(al.contains(num)){
                        al.remove(Integer.valueOf(num));
                    }
                    else{
                        al.add(num);
                    }
                    break;
                case "all" :
                    al.clear();
                    for(int a=1; a<=20;a++){
                        al.add(a);
                    }
                    break;
                case "empty" :
                    al.clear();
                    break;
            }

        }
        bw.flush();



    }
}