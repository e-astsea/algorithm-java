class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        int[][] arr = new int[n][n];
        
        for(int i=0; i<arr1.length; i++){
            String binary = Integer.toBinaryString(arr1[i]);
            if(binary.length()<n){
                while(binary.length()<n){
                    binary = "0"+binary;
                }
            }
            for(int j=0; j<binary.length(); j++){
                if(binary.charAt(j)=='1')
                    arr[i][j]=1; 
            }
        }
        for(int i=0; i<arr2.length; i++){
            String binary = Integer.toBinaryString(arr2[i]);
            if(binary.length()<n){
                while(binary.length()<n){
                    binary = "0"+binary;
                }
            }
            for(int j=0; j<binary.length(); j++){
                if(binary.charAt(j)=='1')
                    arr[i][j]=1; 
            }
        }
        
        String[] answer = new String[n];
        for(int i=0; i<n; i++){
            String str="";
            for(int j=0; j<arr[i].length; j++){
                if(arr[i][j]==1){
                    str = str+"#";
                }
                if(arr[i][j]==0 ){
                    str = str+ " ";
                }
            }
            answer[i]=(str);
        }
        
        return answer;
    }
}