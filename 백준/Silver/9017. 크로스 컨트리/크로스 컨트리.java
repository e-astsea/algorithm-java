import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for(int i=0; i<T; i++){
            ArrayList<Integer> al = new ArrayList<>();
            ArrayList<Integer> index = new ArrayList<>();
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j=0; j<N; j++){
                al.add(Integer.parseInt(st.nextToken()));
            }

            for(int a=0; a<N; a++) {
                int count = Collections.frequency(al, al.get(a));
                if(count<6) {
                    index.add(a);
                }
            }

            for(int a=index.size()-1; a>=0; a--){
                int ind = index.get(a);
                al.remove(ind);
            }

            int []arr = new int[201];
            int []first = new int[201];
            int []five = new int[201];

            for(int a=0; a<al.size(); a++){
                five[al.get(a)]++;
                if(five[al.get(a)]<=4) {
                    arr[al.get(a)] += (a + 1);
                }
                if(five[al.get(a)]==5 ){
                    first[al.get(a)]=a;
                }
            }

            int score=2000;
            int scoretmp=0;
            int team=0;
            for(int a=0; a<201; a++) {
                if (arr[a]!=0 && arr[a] < score) {
                    score = arr[a];
                    scoretmp=a;
                    team = a;
                }
                
                else if(arr[a] == score){
                    if (first[a] < first[scoretmp]) {
                        score = arr[a];
                        team=a;
                    }

                }
            }

            System.out.println(team);
        }
    }
}
