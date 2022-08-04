#include<stdio.h>

int main(){
	
	int i,arr[1000];
	
	arr[0] =1;
	arr[1] =1;
	arr[2] =3;
	
	int a;
	scanf("%d",&a);
	for(i=2;i<=a; i++)
	arr[i]=(arr[i-1]+arr[i-2]+arr[i-2])%10007;
	
	printf("%d",arr[a]);
	
}