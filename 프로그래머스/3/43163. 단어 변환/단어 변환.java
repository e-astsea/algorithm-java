class Solution {
    public int solution(String begin, String target, String[] words) {
        
        checked = new boolean[words.length];
        dfs(begin,target,words,0);
        return min==51?0:min;
    }
    static int min = 51;
    static boolean[] checked;
    public void dfs(String begin, String target, String[] words, int depth){
        if(begin.equals(target)){
            min = Math.min(min,depth);
            return;
        }
        if(depth>=words.length){
            return;
        }
        
        for(int i=0; i<words.length; i++){
            int count = 0;
            for(int j=0; j<begin.length(); j++){
                if(begin.charAt(j)==words[i].charAt(j)){
                    count++;
                }
            }
            if(count != (begin.length()-1)){
                continue;
            }
            if(checked[i]){
                continue;
            }
            checked[i]=true;
            dfs(words[i], target, words, depth+1);
            checked[i]=false;
        }
    }
}