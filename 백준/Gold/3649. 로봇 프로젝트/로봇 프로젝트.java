import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str=null;
        while((str = br.readLine()) != null){
            ArrayList<Integer> al = new ArrayList<>();

            int x = Integer.parseInt(str);
            int n = Integer.parseInt(br.readLine());
            for(int i=0; i<n; i++){
                al.add(Integer.parseInt(br.readLine()));
            }
            Collections.sort(al);
            int start=0 ,start_tmp = 0,end_tmp=0;
            int end = al.size()-1;
            int result = x*10000000;
            boolean flag = false;
            while(start<end){
                int sum = al.get(start)+al.get(end);
                if(sum==result){
                        start_tmp = al.get(start);
                        end_tmp = al.get(end);
                        flag=true;
                        break;
                }
                if(sum<result){
                    start++;
                }
                else if(sum>result){
                    end--;
                }
            }

            if(flag){
                System.out.println("yes "+start_tmp+" "+end_tmp);
            }
            else{
                System.out.println("danger");
            }
        }

    }

}