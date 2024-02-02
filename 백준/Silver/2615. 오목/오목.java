import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] arr = new int[21][21];

        for (int i = 1; i < 20; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j < 20; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        boolean flag = false;
        for (int i = 1; i < 20; i++) {
            for (int j = 1; j < 20; j++) {
                if(arr[i][j] == 1 || arr[i][j] == 2) {

                    //우
                    if(right(arr,i,j)){
                        System.out.println(arr[i][j]);
                        System.out.println(i +" "+ j);
                        flag=true;

                    }
                    //밑
                    if(bottom(arr,i,j)){
                        System.out.println(arr[i][j]);
                        System.out.println(i +" "+ j);
                        flag=true;
                    }
                    //좌하단
                    if(leftDown(arr,i,j)){
                        System.out.println(arr[i][j]);
                        System.out.println(i+4 +" "+ (j-4));

                        flag=true;

                    }
                    //우하단
                    if(rightDown(arr,i,j)){
                        System.out.println(arr[i][j]);
                        System.out.println(i +" "+ j);
                        flag=true;
                    }
                }
            }
        }
        if(flag==false){
            System.out.println("0");
        }
    }

    private static boolean bottom(int[][] arr, int i, int j) {
        int now = arr[i][j];
        if(i>15){
            return false;
        }
        boolean flag = true;
        if(arr[i-1][j] == now){
            return false;
        }
        for (int k = 1; k < 5; k++) {
            if(arr[i+k][j] == now){

            } else{
                flag=false;
                break;
            }
        }
        if(flag){
            if(arr[i+5][j]==now){
                return false;
            }
        }
        return flag;
    }

    private static boolean leftDown(int[][] arr, int i, int j) {
        int now = arr[i][j];
        if(j<5 && i<5){
            return false;
        }
        boolean flag = true;
        if(arr[i-1][j+1] == now){
            return false;
        }
        for (int k = 1; k < 5; k++) {
            if(arr[i+k][j-k] == now){

            } else{
                flag=false;
                break;
            }
        }
        if(flag){
            if(arr[i+5][j-5]==now){
                return false;
            }
        }
        return flag;
    }

    private static boolean rightDown(int[][] arr, int i, int j) {
        int now = arr[i][j];
        if(j>15 && i>15){
            return false;
        }
        boolean flag = true;
        if(arr[i-1][j-1] == now){
            return false;
        }
        for (int k = 1; k < 5; k++) {
            if(arr[i+k][j+k] == now){

            } else{
                flag=false;
                break;
            }
        }
        if(flag){
            if(arr[i+5][j+5]==now){
                return false;
            }
        }
        return flag;
    }

    private static boolean right(int[][] arr, int i, int j) {
        int now = arr[i][j];
        if(j>15){
            return false;
        }
        boolean flag = true;
        if(arr[i][j-1] == now){
            return false;
        }
        for (int k = 1; k < 5; k++) {
            if(arr[i][j+k] == now){

            } else{
                flag=false;
                break;
            }
        }
        if(flag){
            if(arr[i][j+5]==now){
                return false;
            }
        }
        return flag;
    }

}
