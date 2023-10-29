import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Integer> ls;
    static List<Integer> result;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        ls = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            ls.add(Integer.parseInt(st.nextToken()));
        }
        result = new ArrayList<>();
        Collections.sort(ls);
        check = new boolean[N];
        find(N,M,0,0);
    }

    private static void find(int n, int m, int depth, int start) {
        if(depth == m){
            for (int i = 0; i < result.size(); i++) {
                System.out.print(result.get(i)+" ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i < ls.size(); i++) {
                result.add(ls.get(i));
                find(n, m, depth + 1, i);
                result.remove(result.size() - 1);
            }
        }
    }
