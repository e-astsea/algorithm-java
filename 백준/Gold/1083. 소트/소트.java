import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = (Integer.parseInt(st.nextToken()));
        }
        int S = Integer.parseInt(br.readLine());

        for (int i = 0; i < arr.length; i++) {
            if(S <= 0){
                break;
            }
            int maxIndex = i;
            int maxValue = arr[i];
            for (int j = i; j< Math.min(i+S+1,arr.length); j++) {
                if(maxValue < arr[j]){
                    maxIndex = j;
                    maxValue = arr[j];
                }
            }
            swap(i,maxIndex,arr);
            S -= maxIndex-i;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }

    private static void swap(int i, int maxIndex, int[] arr) {
        for (int j = maxIndex; j > i; j--) {
            int tmp = arr[j];
            arr[j] = arr[j-1];
            arr[j-1] = tmp;
        }
    }
}
