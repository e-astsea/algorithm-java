import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A=sc.next();
        String B=sc.next();
        String minA="";
        String maxA="";
        String minB="";
        String maxB="";
        for(int i=0; i<A.length(); i++){
            if(A.charAt(i)=='6'){
                minA += "5";
            }
            else{
                minA += A.charAt(i);
            }

            if(A.charAt(i)=='5'){
                maxA += "6";
            }
            else{
                maxA += A.charAt(i);
            }
        }
        for(int j=0; j<B.length(); j++){
            if(B.charAt(j)=='6'){
                minB += "5";
            }
            else{
                minB += B.charAt(j);
            }

            if(B.charAt(j)=='5'){
                maxB += "6";
            }
            else{
                maxB += B.charAt(j);
            }
        }
        int min_result = Integer.parseInt(minA)+Integer.parseInt(minB);
        int max_result = Integer.parseInt(maxA)+Integer.parseInt(maxB);

        System.out.println(min_result +" "+ max_result);

    }
}

