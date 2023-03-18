import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int M;
    private static int[] arr;
    private static StringTokenizer st;
    private static String str;
    private static int start,end;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        str = br.readLine();
        N = Integer.parseInt(str);
        arr = new int[N];

        str = br.readLine();
        st = new StringTokenizer(str);
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        str = br.readLine();
        M = Integer.parseInt(str);

        str = br.readLine();
        st = new StringTokenizer(str);


        for (int i = 0; i < M; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            Boolean check = search(tmp);
            if (check == true) {
                System.out.println("1");
            } else
                System.out.println("0");
        }
    }

    public static Boolean search(int tmp) {
        start = 0;
        end = N - 1;
        boolean check = false;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] > tmp) {
                end = mid - 1;
            } else if (arr[mid] < tmp) {
                start = mid + 1;
            } else if (arr[mid] == tmp) {
                check = true;
                break;
            }
        }
        return check;
    }
}
