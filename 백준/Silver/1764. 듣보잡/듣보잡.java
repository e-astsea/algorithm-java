import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> map = new HashSet<>();
        HashMap<Integer,String> map2 = new HashMap<>();
        ArrayList<String> result = new ArrayList<>();

        for(int i=0; i<N; i++){
            map.add(br.readLine());
        }

        for(int j=0; j<M; j++){
            String str = br.readLine();
            if(map.contains(str)){
                result.add(str);
            }
        }

        Collections.sort(result);
        sb.append(result.size()+"\n");
        for(int i=0; i<result.size(); i++){
            sb.append(result.get(i)+"\n");
        }
        System.out.print(sb);
    }
}