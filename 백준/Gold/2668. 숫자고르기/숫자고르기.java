import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    static int N;
    static int tmp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        boolean[] checked = new boolean[N+1];
        ls = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= N; i++) {
            checked[i]=true;
            tmp=i;
            dfs(i,arr,checked);
            checked[i]=false;
        }

        System.out.println(ls.size());
        Collections.sort(ls);
        for (int i: ls) {
            System.out.println(i);
        }
    }
    static List<Integer> ls;
// tt tf ft ff
    private static void dfs(int num, int[] arr, boolean[] checked) {
        if(arr[num]==tmp){
            ls.add(num);
        }
        if(!checked[arr[num]]){
            checked[arr[num]]=true;
            dfs(arr[num],arr,checked);
            checked[arr[num]]=false;
        }
    }
//    static Set<Integer> ls = new HashSet<>();
//    private static void check(int[] arr, boolean[] checked) {
//        Map<Integer,Integer> map = new HashMap<>();
//        for (int i = 0; i < checked.length; i++) {
//            if(checked[i]){
//                map.put(i,map.getOrDefault(i,0)+1);
//            }
//        }
//        Set<Integer> tmp = new HashSet<>();
//        map.keySet().stream().forEach(it -> tmp.add(it));
//        for (int i = 0; i < checked.length; i++) {
//            if(checked[i]){
//                map.replace(arr[i]-1,map.getOrDefault(arr[i]-1,0)-1);
//                if(map.containsKey(arr[i]-1) && map.get(arr[i]-1)==0){
//                    map.remove(arr[i]-1);
//                }
//            }
//        }
//
//        if(map.size()==0) {
//            if(tmp.size() > ls.size()){
//                ls = tmp;
//            }
//        }
//    }
}
