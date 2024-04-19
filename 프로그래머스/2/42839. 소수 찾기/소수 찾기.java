import java.util.*;

class Solution {
    public int solution(String numbers) {
        int answer = 0;
        
        checked = new boolean[numbers.length()];
        set = new HashSet<>();
        dfs(numbers, "");
        
        return set.size();
    }
    static int count = 0;
    static boolean[] checked;
    static Set<String> set;
    public void dfs(String numbers, String tmp){
        if(tmp!=""&& tmp.charAt(0) == '0'){
            return;
        }
        if(tmp!="" && tmp.length() <= numbers.length()){
            System.out.println("hi");
            int num = Integer.parseInt(tmp);

            if(prime(num)){
                set.add(tmp);
            }
        }
        for(int i=0; i<numbers.length(); i++){
            if(checked[i]){
                continue;
            }
            checked[i]=true;
            String temp = tmp;
            tmp+=numbers.charAt(i);
            dfs(numbers,tmp);
            tmp = temp;
            checked[i]=false;
        }
    }
    
    public boolean prime(int n) {
		if(n<2) return false;
		
		for(int i=2; i*i<=n; i++) {
			if(n % i == 0) return false;
		}
		
		return true;
	}
}