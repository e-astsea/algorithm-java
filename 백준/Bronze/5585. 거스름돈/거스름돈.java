import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int money=(1000-sc.nextInt());
        int num=0;
        int []arr = {500,100,50,10,5,1};

        for(int i=0; i<arr.length; i++){
            num += (money /arr[i]);
            money = money%arr[i];
        }

        System.out.println(num);
    }
}
