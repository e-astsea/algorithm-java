import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int T = Integer.parseInt(br.readLine());
            PriorityQueue<Integer> minPQ = new PriorityQueue<>();
            PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
            Map<Integer, Integer> map = new HashMap<>();

            for (int j = 0; j < T; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String command = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                if (command.equals("I")) {
                    map.put(num, map.getOrDefault(num, 0) + 1);
                    maxPQ.add(num);
                    minPQ.add(num);
                } else if (command.equals("D")) {
                    if (map.size() == 0) {
                        continue;
                    }
                    if (num == -1) {
                        while (true) {
                            num = minPQ.poll();
                            int cnt = map.getOrDefault(num, 0);
                            if (cnt == 0)
                                continue;
                            if (cnt == 1)
                                map.remove(num);
                            else
                                map.put(num, cnt - 1);
                            break;
                        }
                    } else {
                        while (true) {
                            num = maxPQ.poll();
                            int cnt = map.getOrDefault(num, 0);
                            if (cnt == 0)
                                continue;
                            if (cnt == 1)
                                map.remove(num);
                            else
                                map.put(num, cnt - 1);
                            break;
                        }
                    }
                }
            }
            if (map.size() == 0)
                System.out.println("EMPTY");
            else {
                final int num = remove(maxPQ, map);
                System.out.println(num + " " + (map.size() > 0 ? remove(minPQ, map) : num));
            }
//            if (map.size() == 0) {
//                sb.append("EMPTY" + "\n");
//            } else {
//                int maxPqSize = maxPQ.size();
//                for (int k = 0; k < maxPqSize; k++) {
//                    if (map.getOrDefault(maxPQ.peek(), 0) != 0) {
//                        sb.append(maxPQ.peek() + " ");
//                        break;
//                    } else {
//                        maxPQ.poll();
//                    }
//                }
//                int minPqSize = minPQ.size();
//                for (int k = 0; k < minPqSize; k++) {
//                    if (map.getOrDefault(maxPQ.peek(), 0) != 0) {
//                        sb.append(minPQ.peek());
//                        break;
//                    } else {
//                        minPQ.poll();
//                    }
//                }
//            }
        }
    }

    private static int remove(PriorityQueue<Integer> maxPQ, Map<Integer, Integer> map) {
        int num;
        while (true) {
            num = maxPQ.poll();
            int cnt = map.getOrDefault(num, 0);
            if (cnt == 0)
                continue;
            if (cnt == 1)
                map.remove(num);
            else
                map.put(num, cnt - 1);
            break;
        }
        return num;
    }
}

