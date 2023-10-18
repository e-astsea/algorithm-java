import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));



        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            List<Integer> first = new ArrayList<>();
            List<Integer> second = new ArrayList<>();
            final String str = st.nextToken();
            if(str.equals("0")){
                break;
            }
            int last = Integer.parseInt(str);
            for (int i = 0; i < last; i++) {
                final int num = Integer.parseInt(st.nextToken());
                first.add(num);
            }

            st = new StringTokenizer(br.readLine());
            last = Integer.parseInt(st.nextToken());
            for (int i = 0; i < last; i++) {
                final int num = Integer.parseInt(st.nextToken());
                second.add(num);
            }

            int sum = 0;

            int firstIndex = 0;
            int secondIndex = 0;
            int firstSum = 0;
            int secondSum = 0;

            while (true) {
                if (first.size() <= firstIndex) {
                    for (int i = secondIndex; i < second.size(); i++) {
                        secondSum += second.get(i);
                    }
                    sum += Math.max(firstSum, secondSum);
                    break;
                }
                if (second.size() <= secondIndex) {
                    for (int i = firstIndex; i < first.size(); i++) {
                        firstSum += first.get(i);
                    }
                    sum += Math.max(firstSum, secondSum);
                    break;
                }
                final Integer num1 = first.get(firstIndex);
                final Integer num2 = second.get(secondIndex);
                if (num1 > num2) {
                    secondSum += num2;
                    secondIndex++;
                } else if (num2 > num1) {
                    firstSum += num1;
                    firstIndex++;
                } else {
                    if (firstSum >= secondSum) {
                        sum += firstSum + num1;
                    } else if (secondSum >= firstSum) {
                        sum += secondSum + num2;
                    }
                    firstSum = 0;
                    secondSum = 0;
                    firstIndex++;
                    secondIndex++;
                }
            }

            System.out.println(sum);
        }
    }
}
