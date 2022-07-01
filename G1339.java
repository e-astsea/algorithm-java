import java.util.Arrays;
import java.util.Scanner;

public class G1339 {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        int N = sc.nextInt();
        String str;     //입력하는 문자열
        int []alphabet = new int[26];       //문자열 알파벳 계수 저장할 알파벳 공간
        int tmp=0;      //1 10 100 등 자릿수 나타낼 임시변수

        for(int i=0; i<N; i++){
            tmp=1;
            str = sc.next();
            for(int j=str.length()-1; j>=0; j--){
                alphabet[(int)str.charAt(j)-65] += tmp;
                tmp*=10;
            }
        }

        //정렬 후 내림차 순 정렬 해주는 곳
        Arrays.sort(alphabet);
        int temp=0;
        for (int i = 0; i < alphabet.length / 2; i++) {
            temp = alphabet[i];
            alphabet[i] = alphabet[(alphabet.length - 1) - i];
            alphabet[(alphabet.length - 1) - i] = temp;
        }


        int sum=0;
        for(int i=0; i<26; i++){
            if(alphabet[i]==0){
                break;
            }
            sum += alphabet[i]*(9-i);
        }
        System.out.println(sum);

    }
}

