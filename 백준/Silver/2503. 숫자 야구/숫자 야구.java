import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class Result{
        int num;
        int strike;
        int ball;

        public Result(int num, int strike, int ball) {
            this.num = num;
            this.strike = strike;
            this.ball = ball;
        }

        public boolean calculate(int number){
            int st = 0;
            int ba = 0;
            int first = num/100;
            int second = num/10-first*10;
            int third = num-first*100-second*10;

            int newFirst = number/100;
            int newSecond = number/10-newFirst*10;
            int newThird = number-newFirst*100-newSecond*10;

            if(newFirst ==0 || newSecond==0||newThird==0){
                return false;
            }

            if(newFirst==newSecond || newFirst==newThird||newSecond==newThird){
                return false;
            }

            if(first == newFirst){
                st++;
            } else if(first == newSecond || first == newThird){
                ba++;
            }

            if(second == newSecond){
                st++;
            } else if(second == newFirst || second == newThird){
                ba++;
            }

            if(third == newThird){
                st++;
            } else if(third == newSecond || third == newFirst){
                ba++;
            }


            if(st==this.strike && ba==this.ball){
                return true;
            } else{
                return false;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Result> ls = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());

            ls.add(new Result(num,strike,ball));
        }

        int count = 0;
        for (int i = 100; i < 999; i++) {
            boolean flag = true;
            for (int j = 0; j < ls.size(); j++) {
                if(ls.get(j).calculate(i)){
                    continue;
                }else{
                    flag = false;
                    break;
                }
            }
            if (flag){
                count++;
            }
        }
        System.out.println(count);
    }
}
