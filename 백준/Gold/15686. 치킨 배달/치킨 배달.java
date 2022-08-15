import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

//처음 접근  - 조합으로 치킨집들중 M개 뽑기 -> 구현은 어떻게 ?
//삼성 SW 역량테스트 기출 문제

class pair{
    int x;
    int y;
    pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static int N,M,tmp,tmp_house;
    static pair [] chicken;
    static pair [] house;
    static int [][]save_chicken;
    static int[][] arr;
    static ArrayList<pair> select;
    static int final_result=Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N+1][N+1];
        chicken = new pair[N*N];
        tmp=0;
        tmp_house=0;
        select = new ArrayList<>();
        house = new pair[N*N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j]==2){
                    chicken[tmp]=new pair(i,j);
                    tmp++;
                }
                else if(arr[i][j]==1){
                    house[tmp_house]=new pair(i,j);
                    tmp_house++;
                }
            }
        }

        combination(0,0);
        System.out.println(final_result);
    }
    static void combination(int start, int depth){
        if(depth==M){
            int fr = find();
            final_result = Math.min(fr,final_result);
        }

        for(int i=start; i<tmp; i++) {
            pair p = chicken[i];
            select.add(p);
            combination(i+1,depth+1);
            select.remove(select.size()-1);
        }
    }

    static int find(){
        int result_int=0;
        for(int i=0; i<tmp_house; i++){
            pair p = house[i];
            int min_result=Integer.MAX_VALUE;
            for(int k=0; k<select.size(); k++){
                pair sel = select.get(k);
                int distance = Math.abs(p.x-sel.x)+Math.abs(p.y-sel.y);
                min_result = Math.min(min_result,distance);
            }
            result_int+=min_result;
        }
        return result_int;
    }
}