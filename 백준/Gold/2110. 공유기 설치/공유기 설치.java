import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer> al;
    static int N;
    static int num;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str=br.readLine();
        StringTokenizer st = new StringTokenizer(str);

        N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        al = new ArrayList<>();
        for(int i=0; i<N; i++){
            al.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(al);

        int start= 0;
        int end = 1000000001;
        int result=0;
        int solved=0;
        while(start<=end){
            int mid = (start+end)/2;
            result = func(mid); // result 는 mid의 사이 거리에서 갯수
            //System.out.println(start+" "+mid+" "+end+" "+result);

            if(result<C){
                end = mid-1;

            }
            else if(result>=C) {
                start = mid + 1;
                solved = mid;
            }
        }
        System.out.println(solved);
    }
    static int func(int x){
        num=1;
        int tmp = al.get(0)+x;
        for(int i=1; i<N; i++){

            if(tmp<=al.get(i)){
                tmp = al.get(i)+x;
                num++;
            }
        }
        return num;
    }
}