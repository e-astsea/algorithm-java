import java.util.Scanner;

public class S4796 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i=0;
        while(true){
            int L=sc.nextInt();
            int P=sc.nextInt();
            int V=sc.nextInt();
            if(L==0 && P == 0 && V == 0){
                break;
            }

            int div=V/P;
            int per=V%P;
            int re = 0;

            if(per>L){
                re = L;
            }
            else
                re = per;

            re += div*L;
            System.out.println("Case"+" "+ ++i +": "+re);
        }

    }
}

