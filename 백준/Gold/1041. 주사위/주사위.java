import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

//조합으로 풀수있을 것 같은데 귀찮다..
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Long N = Long.parseLong(br.readLine());
        List<Integer> ls = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 6; i++) {
            ls.add(Integer.parseInt(st.nextToken()));
        }

        if(N == 1){
            Collections.sort(ls);
            System.out.println(ls.get(0)+ls.get(1)+ls.get(2)+ls.get(3)+ls.get(4));
            return;
        }

        Long one = (5*(N-2) * (N-2) + 4*(N-2)) * one(ls);
        Long two = (8*N-12) * two(ls);
        Long three = 4L * three(ls);

        Long answer = one + two + three;
        System.out.println(answer);
    }

    private static long three(List<Integer> ls) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < ls.size(); i++) {
            for (int j = 0; j < ls.size(); j++) {
                if (check(i, j)) {
                    continue;
                }
                for (int k = 0; k < ls.size(); k++) {
                    if(k==i || k==j){
                        continue;
                    }
                    if(k+i==5 || k+j==5){
                        continue;
                    }
                    min = Math.min(min,ls.get(i)+ls.get(j)+ls.get(k));
                }
            }
        }
        return min;
    }

    private static long two(List<Integer> ls) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < ls.size(); i++) {
            for (int j = 0; j < ls.size(); j++) {
                if (check(i, j)) {
                    continue;
                }
                min = Math.min(min,ls.get(i)+ls.get(j));
            }
        }
        return min;
    }

    private static long one(List<Integer> ls) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < ls.size(); i++) {
            min = Math.min(min,ls.get(i));
        }
        return min;
    }


    private static boolean check(int i, int j) {
        if(i == j){
            return true;
        }
        if(i + j == 5){
            return true;
        }
        return false;
    }
}
