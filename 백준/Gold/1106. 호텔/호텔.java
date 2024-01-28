import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class City{
        int cost;
        int customers;

        public City(int cost, int customers) {
            this.cost = cost;
            this.customers = customers;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        List<City> ls = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int customers = Integer.parseInt(st.nextToken());
            ls.add(new City(cost,customers));
        }

        Collections.sort(ls,((o1, o2) -> o1.customers < o2.customers ? -1 : 1));

        int[] dp = new int[1102];
        Arrays.fill(dp,100000);

        int min = Integer.MAX_VALUE;
        dp[0]=0;
        for (int i = 0; i < ls.size(); i++) {
            City city = ls.get(i);

            for (int j = 1; j <= C+101; j++) {
                if(j- city.customers>=0){
                    dp[j] = Math.min(dp[j], dp[j-city.customers] + city.cost);
                }
                if(dp[j] != Integer.MAX_VALUE && j>=C){
                    min = Math.min(min,dp[j]);
                }
            }

        }

        System.out.println(min);
    }
}
