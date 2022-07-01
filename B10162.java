import java.util.Scanner;

public class B10162 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sec = sc.nextInt();
        int min = 0;
        if(sec>=60){
            min = sec/60;
            sec %= 60;
        }
        int a=0,b=0,c=0;

        if(min>=5){
            a = (min / 5);
            min %=5;
        }
        if(min>0){
            b = (min/1);
            min %=1;
        }
        if(sec%10==0){
            c = sec/10;
        }
        else {
            System.out.println("-1");
            return;
        }

        System.out.println(a+" "+b+" "+c);
    }
}
