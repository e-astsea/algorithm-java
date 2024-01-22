import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Time{
        int startTime;
        int endTime;

        public Time(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Time> times = new PriorityQueue<>((o1, o2) -> {
            if(o1.startTime == o2.startTime){
                return o1.endTime < o2.endTime ? -1 : 1;
            }
            return o1.startTime < o2.startTime ? -1 : 1;
        });

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            times.add(new Time(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }

        int[] arr = new int[100000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = -1;
        }

        int size = times.size();
        for (int i = 0; i < size; i++) {
            Time time = times.poll();
            for (int j = 0; j < arr.length; j++) {
                if(arr[j] == -1 || (arr[j] <= time.startTime && arr[j]!=-1)){
                    arr[j] = time.endTime;
                    break;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==-1){
                break;
            }
            count++;
        }
        System.out.println(count);
    }
}
