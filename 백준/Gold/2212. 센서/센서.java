import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N=sc.nextInt();
        int K=sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>(N);
        for(int i=0; i<N; i++){
            int type = sc.nextInt();
            if(!arr.contains(type))
                arr.add(type);
        }

        Collections.sort(arr);



        ArrayList<Integer> sensor_length = new ArrayList<>(arr.size());
        if(N==1){
            System.out.println(0);
            return;
        }
        for(int i=0; i<arr.size()-1; i++){
            sensor_length.add(arr.get(i+1)-arr.get(i));
        }


        Collections.sort(sensor_length,Collections.reverseOrder());

        for(int j=0; j<K-1; j++){
            sensor_length.remove(0);
        }

        int result=0;
        for(int i=0; i<sensor_length.size(); i++){
            result += sensor_length.get(i);
        }
        System.out.println(result);

    }
}


