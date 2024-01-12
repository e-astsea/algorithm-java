import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static class Problem{
        int P;
        int L;
        boolean solved = false;

        public Problem(int p, int l) {
            P = p;
            L = l;
        }

        public void solvedProblem() {
            this.solved = true;
        }

        public int getP() {
            return P;
        }

        public int getL() {
            return L;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Problem> minPQ = new PriorityQueue<>((o1, o2) -> {
            if (o1.L == o2.L) {
                return o1.getP() > o2.getP() ? 1:-1;
            }
            return o1.getL() > o2.getL() ? 1:-1;
        });

        PriorityQueue<Problem> maxPQ = new PriorityQueue<>((o1, o2) -> {
            if (o1.L == o2.L) {
                return o1.getP() < o2.getP() ? 1:-1;
            }
            return o1.getL() < o2.getL() ? 1:-1;
        });

        Map<Integer,Problem> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
            final Problem problem = new Problem(P, L);
            map.put(P,problem);
            maxPQ.offer(problem);
            minPQ.offer(problem);
        }

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if(command.equals("add")){
                final int P = Integer.parseInt(st.nextToken());
                final int L = Integer.parseInt(st.nextToken());
                final Problem problem = new Problem(P, L);
                map.put(P,problem);
                maxPQ.add(problem);
                minPQ.add(problem);
            } else if(command.equals("recommend")){
                if(Integer.parseInt(st.nextToken()) == -1){
                    while(true){
                        Problem p = minPQ.peek();
                        if(!p.solved){
                            System.out.println(p.getP());
                            break;
                        }
                        minPQ.poll();
                    }
                }else{
                    while(true){
                        Problem p = maxPQ.peek();
                        if(!p.solved){
                            System.out.println(p.getP());
                            break;
                        }
                        maxPQ.poll();
                    }
                }
            } else if (command.equals("solved")) {
                final Problem problem = map.get(Integer.parseInt(st.nextToken()));
                problem.solvedProblem();
            }
        }

    }
}
