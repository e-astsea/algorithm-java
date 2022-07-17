#include<iostream>
#include<string>

using namespace std;

int main(){
    int N;

    cin >> N;

    int result =0;
    int i=N;
    int final_result=0;
    for(int i=N-1; i>0; i--){
        result = i;  
        int j=i;
        while(1){    
            int jaritnum = 10;
            int div=0;
            div = j%jaritnum;
            result += div;
            j/=10;
            if(j==0){
                break;
            }
            jaritnum*=10;
        }

        if(result == N){
            final_result = i;
        }
    }
    cout << final_result;
}