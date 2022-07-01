import java.util.Scanner;

public class S2839 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N= sc.nextInt();
        int count = 5001;
        for(int i=0; ; i++){
            int re=0;
            re+=(i*5);

            if(re>N){
                break;
            }
            else if(re ==N){
                if(count >i){
                    count = i;
                }
                break;
            }

            for(int j=0; ; j++){
                re+=3;

                if(re>N){
                    break;
                }
                else if(re ==N){
                    if(count > i+j+1){
                        count =i+j+1;
                    }
                    break;
                }
            }
        }
        if(count ==5001){
            System.out.println("-1");
        }
        else{
            System.out.println(count);
        }
    }
}
