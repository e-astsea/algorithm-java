import java.io.*;

public class Main {
    static int N,result;
    static int [][]table;
    static int [][]checked;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        table = new int[N+1][N+1];

        for(int i=0; i<N; i++) {
            checked = new int[N+1][N+1];
            checked[0][i]=1;
            dfs(0,i,1);
        }
        System.out.println(result);
    }

    static void dfs(int column , int row , int depth){
        if(depth==N){
            result++;
            return;
        }
        // + 방향

        // 대각방향
        LOOP1:
        for(int i=0; i<N; i++) {
            if(checked[column+1][i]!=0){
                continue;
            }

            for(int a=0; a<N; a++){
                if(checked[a][i]==1){
                  continue LOOP1;
                }
                if(checked[column+1][a]==1){
                    continue LOOP1;
                }
            }

            for(int a=0; a<=N; a++){
                if((column+a<N) && (i+a<N) && (column+1+a>=0) && (i+a>=0) && checked[column+1+a][i+a]==1){
                    continue LOOP1;
                }
                if((column+a<N) && (i-a<N)&& (column+1+a>=0) && (i-a>=0) && checked[column+1+a][i-a]==1){
                    continue LOOP1;
                }
                if((column-a<N) && (i+a<N)&& (column+1-a>=0) && (i+a>=0) && checked[column+1-a][i+a]==1){
                    continue LOOP1;
                }
                if((column-a<N) && (i-a<N)&& (column+1-a>=0) && (i-a>=0) && checked[column+1-a][i-a]==1){
                    continue LOOP1;
                }
            }

            checked[column+1][i]=1;
            dfs(column + 1, i, depth + 1);
            checked[column+1][i]=0;
        }

    }
}