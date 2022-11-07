#include<iostream>

using namespace std;

int main(){
    int n,m;
    cin >> n >> m;
    int arr[n];
    for(int i=0; i<n; i++){
        cin >> arr[i];
    }
    int result = 0;
    for(int i=0; i<n; i++){
        for(int j=i+1; j<n; j++){
            for(int k= j+1; k<n; k++){
                if(arr[i]+arr[j]+arr[k] <= m && (arr[i]+arr[j]+arr[k]>result)){
                    result = arr[i]+arr[j]+arr[k];
                }
            }
        }
    }
    cout << result;
}