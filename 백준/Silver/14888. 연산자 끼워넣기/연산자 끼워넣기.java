import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Integer> ls = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] signal = new int[4];
        for (int i = 0; i < N; i++) {
            ls.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        signal[0] = Integer.parseInt(st.nextToken()); //+
        signal[1] = Integer.parseInt(st.nextToken()); //-
        signal[2] = Integer.parseInt(st.nextToken()); //*
        signal[3] = Integer.parseInt(st.nextToken()); ///

        dfs(ls, signal,0, ls.get(0));
        System.out.println(max);
        System.out.println(min);
    }
    static int[] signalCount = new int[4];
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    private static void dfs(List<Integer> ls, int[] signal, int depth, int result) {
        if(depth == ls.size()-1){
            max = Math.max(result,max);
            min = Math.min(result,min);
            return;
        }

        for (int i = 0; i < signal.length; i++) {
            if(signal[i] > 0 && signalCount[i]<signal[i]){
                if(i==0){
                    signalCount[i]++;
                    dfs(ls,signal,depth+1, result+ls.get(depth+1));
                    signalCount[i]--;
                }
                if(i==1){
                    signalCount[i]++;
                    dfs(ls,signal,depth+1, result-ls.get(depth+1));
                    signalCount[i]--;
                }
                if(i==2){
                    signalCount[i]++;
                    dfs(ls,signal,depth+1, result*ls.get(depth+1));
                    signalCount[i]--;
                }
                if(i==3){
                    signalCount[i]++;
                    dfs(ls,signal,depth+1, result/ls.get(depth+1));
                    signalCount[i]--;
                }
            }
        }
    }
    /*
    우선 순위 무시하고 앞에서부터
    나눗셈은 정수 몫만

     */
}
