import java.util.*;

class Solution {
    enum english {
        zero(0),
        one(1),
        two(2),
        three(3),
        four(4),
        five(5),
        six(6),
        seven(7),
        eight(8),
        nine(9);

        final int value;

        english(int value) {
            this.value = value;
        }

        public static Optional<english> find(String str) {
            return Arrays.stream(english.values())
                    .filter(it -> it.equals(str))
                    .findAny();
        }
    }

    public int solution(String s) {
        int answer = 0;
        String str = "";
        for(int i=0; i<s.length(); i++){
            if(48<= s.charAt(i) && s.charAt(i) <=57){
                answer = answer * 10 + Integer.parseInt(String.valueOf(s.charAt(i)));
            }
            else{
                str = str.concat(String.valueOf(s.charAt(i)));
                
                for(int j=0; j<english.values().length; j++){
                    if(str.equals(english.values()[j].name())){
                        System.out.println(str);
                        answer = answer * 10 + english.valueOf(str).value;
                        str = "";
                    }
                }
            }
        }
        return answer;
    }
}