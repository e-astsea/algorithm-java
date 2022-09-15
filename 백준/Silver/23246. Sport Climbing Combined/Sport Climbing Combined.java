import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer> al;
    static int N;
    static int num;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        int[][] arr = new int[num][3];

        for(int i=0; i<num; i++){
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);
            arr[i][0]= Integer.parseInt(st.nextToken());
            int a= Integer.parseInt(st.nextToken());
            int b= Integer.parseInt(st.nextToken());
            int c= Integer.parseInt(st.nextToken());
            arr[i][1]= a*b*c;
            arr[i][2] = a+b+c;
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {

                if(o1[1]!=o2[1])
                    return o1[1]-o2[1];
                else if(o1[2]!=o2[2]){
                    return o1[2]-o2[2];
                }
                else {
                    return o1[0]-o2[0];
                }
            }
        });


        for(int i=0; i<3; i++) {
            System.out.print(arr[i][0]+" ");
        }
    }
}