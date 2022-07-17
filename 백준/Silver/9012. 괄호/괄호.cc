#include<iostream>
#include<algorithm>
#include <stack>
#include <string>

using namespace std;

int main(void) {

	int N;
	cin >> N;

	string a;
	int cnt = 1;

	for (int i = 0; i < N; i++) {
		cin >> a;
		stack<char> s;
		int cnt = 1;

		for (int j = 0; j < a.size(); j++) {
			if (a[j] == '(') {
				s.push('(');
			}
			else if (a[j] == ')') {
				if (s.empty() == 1) {
					cnt = 0;
					break;
				}
				else
					s.pop();
			}
		}
		if (s.empty() != 1) {
			cnt = 0;
		}
		if (cnt == 0) {
			cout << "NO"<<"\n";
		}
		else
			cout << "YES"<<"\n";
	}
	
}
	


