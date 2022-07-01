import java.util.Scanner;

public class B2525 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A,B,C;
        A=sc.nextInt();
        B=sc.nextInt();
        C=sc.nextInt();

        B+=C;
        if(B>=60){
            A+=(B/60);
            B=B%60;
        }

        if(A>=24){
            A-=24;
        }
        System.out.println(A+" "+B);
    }
}
