import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int T = Integer.parseInt(str);

        for(int i=0; i<T; i++){
            ArrayList<Integer> al = new ArrayList<>();
            ArrayList<Integer> index = new ArrayList<>();

            str = br.readLine();
            int N = Integer.parseInt(str);

            str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);

            //입력
            for(int j=0; j<N; j++){
                al.add(Integer.parseInt(st.nextToken()));
            }

            //6개 미만 팀 제거
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


            //5등 먼저 들어오는 팀 five배열통해 first 에 기록 하고 합산점수 arr에 기록
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


            //최저이면서 같은 성적일경우 first에 있는 거 위주로
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