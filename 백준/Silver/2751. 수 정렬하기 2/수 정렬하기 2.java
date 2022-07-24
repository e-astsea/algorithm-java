import java.io.*;

public class Main {
    static int[] arr = new int[10000001];
    static int[] tmp = new int[10000001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        int N = Integer.parseInt(str);
        for(int i=0; i<N; i++){
            str = br.readLine();
            arr[i]=Integer.parseInt(str);
        }
        mergesort(arr,0,N-1);

        for(int i=0; i<N; i++){
            bw.write(arr[i]+"\n");
        }
        bw.flush();
    }

    static void mergesort(int[] arr, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergesort(arr, start, mid);
            mergesort(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
    }
    static void merge(int[] arr, int start, int mid, int end){
        int left = start;
        int right = mid+1;
        int index = start;
        while(left <= mid && right<=end){
            if(arr[left]<=arr[right]){
                tmp[index++]=arr[left++];
            }
            else{
                tmp[index++]=arr[right++];
            }
        }
        while(left<=mid){
            tmp[index++]=arr[left++];
        }
        while(right<=mid){
            tmp[index++]=arr[right++];
        }

        for(int i=start; i<index; i++) {
            arr[i] = tmp[i];
        }
    }
}