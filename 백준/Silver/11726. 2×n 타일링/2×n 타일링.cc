  #include<stdio.h>
  
  int main()
  {
  	int i,n;
  	int arr[1000];
  
  arr[0] = 1;
  arr[1] = 1;
 
    scanf("%d", &n);
 
    for (int i = 2; i <= n; i++)
        arr[i] =  (arr[i - 1] + arr[i - 2])%10007;


	printf("%d",arr[n]);

}