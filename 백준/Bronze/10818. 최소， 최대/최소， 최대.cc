#include<iostream>
using namespace std;

int main(void) {

	int N;
	cin >> N;
	//int arr[1000000];
	int temp;
	int max = (-1000000), min = 1000000;

	for (int i = 1; i <= N; i++) {
		cin >> temp;
		if (temp < min)
			min = temp;
		if (temp > max)
			max = temp;

	}
	cout << min << " " << max << endl;
}

