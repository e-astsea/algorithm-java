class Solution
{

    public int solution(int n, int a, int b)
    {
        int answer = 0;
        
        while(true){
            if(a%2==1 && a+1 == b){
                break;
            }
            if(b%2==1 && b+1 == a){
                break;
            }
            a= a/2 + a%2;
            b= b/2 + b%2;
            answer++;
        }
    
        return answer+1;
    }
}