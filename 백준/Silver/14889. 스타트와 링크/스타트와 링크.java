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

        int[][] arr = new int[N][N];
        firstTeams = new ArrayList<>();
        secondTeams = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(arr,0);
        System.out.println(result);
    }

    static List<Integer> firstTeams;
    static List<Integer> secondTeams;
    static int result = Integer.MAX_VALUE;
    static boolean check = false;
    private static void dfs(int[][] arr, int depth) {
        if(depth == arr.length/2){
            int firstTeam = 0;
            int secondTeam = 0;
//            for (int i = 0; i < firstTeams.size(); i++) {
//                System.out.print(firstTeams.get(i)+" ");
//            }
//            System.out.println("");
            for (int i = 0; i < arr.length; i++) {
                for (int j = i+1; j < arr.length; j++) {
                    if(firstTeams.contains(i) && firstTeams.contains(j)){
                        firstTeam+= arr[i][j];
                        firstTeam+= arr[j][i];
                    } else if(!firstTeams.contains(i) && !firstTeams.contains(j)){
                        secondTeam+= arr[i][j];
                        secondTeam+= arr[j][i];
                    }
                }
            }
//            System.out.println(firstTeam+" "+secondTeam);
            result = Math.min(result,Math.abs(firstTeam-secondTeam));
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!firstTeams.contains(i)) {
                if (i >= 0 && firstTeams.size()>0 && firstTeams.get(firstTeams.size()-1) > i) {
                    continue;
                }
                firstTeams.add(i);
                dfs(arr, depth + 1);
                firstTeams.remove((Object) i);
            }
        }
    }
}
