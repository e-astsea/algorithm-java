import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N= sc.nextInt();

        ArrayList<Integer> arr_minus = new ArrayList<>(N);
        ArrayList<Integer> arr_plus = new ArrayList<>(N);
        int zero =0;
        int result=0;
        for(int i=0; i<N; i++){
            int temp = sc.nextInt();
            if(temp>1){
                arr_plus.add(temp);
            }
            else if(temp<0)
                arr_minus.add(temp);
            else if(temp==1){
                result+=1;
            }
            else if(temp ==0){
                zero=1;
            }
        }

        Collections.sort(arr_minus);
        Collections.sort(arr_plus,Collections.reverseOrder());

        for(int i=0; i<arr_plus.size(); i++){
            if(i == arr_plus.size()-1 && arr_plus.size()%2 == 1){
                result += arr_plus.get(i);
            }
            else {
                result += (arr_plus.get(i) * arr_plus.get(i + 1));
                i++;
            }
        }

        int fc=0;
        for(int i=0; i<arr_minus.size(); i++){
            if(i==arr_minus.size()-1 && arr_minus.size()%2 == 1){
                if(zero==1) {
                    result += arr_minus.get(i)*0;
                }
                else{
                    result += arr_minus.get(i);
                }
            }
            else {
                result += (arr_minus.get(i) * arr_minus.get(i +1));
                i++;
            }
        }

        System.out.println(result);


    }
}


