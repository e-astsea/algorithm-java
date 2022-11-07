import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());


        int count=0;
        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            ArrayList<Character> al = new ArrayList<>();
            Character beforeChar = ' ';
            for (int j = 0; j < temp.length(); j++) {

                if (!al.contains(temp.charAt(j))) {
                    al.add(temp.charAt(j));
                    beforeChar = temp.charAt(j);
                } else if (al.contains(temp.charAt(j)) && temp.charAt(j) != beforeChar) {
                    break;
                }
                if(j==temp.length()-1){
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
