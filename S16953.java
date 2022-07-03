import java.util.Scanner;

public class S16953 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int count = 1;
        while (true) {
            if (B < A) {
                System.out.println("-1");
                break;
            }
            if (B == A) {
                System.out.println(count);
                break;
            }
            if (B % 2 == 0) {
                count++;
                B = B / 2;
            }
            else if (B % 10 == 1) {
                count++;
                B = B / 10;
            }
            else{
                System.out.println("-1");
                break;
            }

        }
    }
}

