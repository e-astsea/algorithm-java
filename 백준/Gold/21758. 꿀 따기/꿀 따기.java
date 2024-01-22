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
        for (int i = 0; i < N; i++) {
            ls.add(Integer.parseInt(st.nextToken()));
        }

        //좌측 끝
        int leftResult = 0;
        for (int i = 0; i < ls.size()-2; i++) {
            leftResult+=ls.get(i)*2;
        }
        int moveLeftResult = leftResult;

        for (int i = ls.size()-2; i >2; i--) {
            moveLeftResult+=ls.get(i);
            moveLeftResult-=ls.get(i-1)*2;
            leftResult = Math.max(moveLeftResult,leftResult);
        }

        //우측 끝
        int rightResult = 0;
        for (int i = 2; i < ls.size(); i++) {
            rightResult+=ls.get(i)*2;
        }
        int moveRightResult = rightResult;

        for (int i = 2; i < ls.size()-2; i++) {
            moveRightResult+=ls.get(i-1);
            moveRightResult-=ls.get(i)*2;
            rightResult = Math.max(moveRightResult,rightResult);
        }

        //가운데
        int left = ls.get(1);
        int right = 0;
        for (int i = 1; i < ls.size()-1; i++) {
            right += ls.get(i);
        }

        int result = left+right;
        for (int i = 2; i < ls.size()-1; i++) {
            left+=ls.get(i);
            right-=ls.get(i);
            result = Math.max(result,left+right);
        }
//        System.out.println(rightResult+" "+leftResult+" "+result);
        System.out.println(Math.max(Math.max(rightResult,leftResult),result));
    }
}
