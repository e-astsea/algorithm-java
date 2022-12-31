import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String N = sc.nextLine();
        int result=0;
        int []arr = new int[N.length()];
        for(int i=0; i<N.length(); i++){
            result+= N.charAt(i)-'0';
            arr[i] = N.charAt(i)-'0';
        }
        Arrays.sort(arr);
        if(result %3 !=0 || arr[0] != 0){
            System.out.println("-1");
            return ;
        }
        for(int i=N.length()-1; i>=0; i--){
            System.out.print(arr[i]);
        }
    }
}