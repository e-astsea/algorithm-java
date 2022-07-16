import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int [] checked = new int[100001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int G = Integer.parseInt(str);
        str = br.readLine();
        int P = Integer.parseInt(str);

        Arrays.fill(checked,-1);
        int count=0;
        for(int i=0; i<P; i++){
            if(find(Integer.parseInt(br.readLine())) == -2){
                break;
            }
            count++;
        }
        System.out.println(count);

    }

    public static int find(int x){
        if(x==0){
            return -2;
        }
        if(checked[x]<0){
            return (checked[x]=x-1);
        }
        else{
            return checked[x]=find(checked[x]);
        }
    }


}