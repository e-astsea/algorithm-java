#include<iostream>
#include<algorithm>
#include<string.h>
#include<list>
#include<vector>

using namespace std;

bool compare(string a, string b) {
	if (a.length() != b.length()) {
		return a.length() < b.length();
	}
	else {
		return a < b;
	}
}

int main(void) {
	int N;
	cin >> N;

	string arr[20000];

	for (int i = 0; i < N; i++) {
		cin >> arr[i];
	}
	sort(arr, arr + N,compare);
	for (int j = 0; j < N; j++) {
		string temp;
		if (arr[j]==arr[j+1]){
			continue;
		}
		cout << arr[j]<<"\n";
	}

}
	


