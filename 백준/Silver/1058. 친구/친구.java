import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        boolean[][] tmp = new boolean[N][N];
        List<Set<Integer>> friend = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            friend.add(new HashSet<>());
        }
        
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j <N; j++) {
                tmp[i][j] = str.charAt(j) == 'Y';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j <N; j++) {
                if(tmp[i][j]){
                    friend.get(i).add(j);
                    for (int k = 0; k < N; k++) {
                        if(tmp[j][k] && k!=i) {
                            friend.get(i).add(k);
                        }
                    }
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            answer = Math.max(answer, friend.get(i).size());
        }
        System.out.println(answer);
    }
}
