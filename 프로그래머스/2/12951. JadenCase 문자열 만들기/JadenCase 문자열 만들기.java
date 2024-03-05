class Solution {
    public String solution(String s) {
        boolean check = true;
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<s.length(); i++){

            if(check && s.charAt(i) != ' '){
                if(s.charAt(i)>=97 && s.charAt(i)<=122){
                    sb.append(String.valueOf((char)(s.charAt(i)-32)));
                } else{
                    sb.append(String.valueOf(s.charAt(i)));
                }
                
                check=false;
            } else{
                if(s.charAt(i)>=65 && s.charAt(i)<=90){
                    sb.append(String.valueOf((char)(s.charAt(i)+32)));
                }else{
                    sb.append(String.valueOf(s.charAt(i)));
                }
                if(s.charAt(i)==' '){
                    check=true;
                }
            }
        }
        return sb.toString();
    }
}