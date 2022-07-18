import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String N =sc.nextLine();
        int count_1=0;
        int count_0=0;

        if(N.charAt(0)=='0')
            count_0++;
        else
            count_1++;

        for(int i=1; i<N.length(); i++){
            if(N.charAt(i-1)!=N.charAt(i)) {
                if (N.charAt(i)=='0'){
                    count_0++;
                }
                if (N.charAt(i)=='1'){
                    count_1++;
                }
            }
        }
        System.out.println(Math.min(count_1,count_0));

    }
}

