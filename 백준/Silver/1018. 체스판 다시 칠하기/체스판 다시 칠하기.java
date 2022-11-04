import java.io.*;
import java.util.*;

public class Main {
    static Character Warr[][] = {{'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'}};
    static Character Barr[][] = {{'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'}};
    static int N;
    static int M;
    static Character [][]arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new Character[N+1][M+1];

        for(int i=0; i<N;i++){
            str=br.readLine();
            for(int j=0; j<M; j++){
                arr[i][j]=str.charAt(j);
            }
        }

        for(int i=0; i<=N-8; i++){
            for(int j=0; j<=M-8; j++){
                brute(i,j);
            }
        }
        System.out.println(result);
    }
    static int result=64;
    static void brute(int x, int y){
        int b=0;
        int w=0;
        for(int i = x; i<x+8; i++){
            for(int j=y; j<y+8;j++){
                if(arr[i][j]!=Warr[i-x][j-y]){
                    w++;
                }
                if(arr[i][j]!=Barr[i-x][j-y]){
                    b++;
                }
            }
        }
        int re = Math.min(w,b);
        if(re < result){
            result = re;
        }


    }
}