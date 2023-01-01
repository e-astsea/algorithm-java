#include <iostream>
#include <algorithm>
#include <stack>

using namespace std;

const int MX = 1000005;
int dat[MX];
int pos = 0;

int main(void) {
	stack<int> s;
	int N;
	cin >> N;
	string ans;
	for (int i = 0; i < N; i++) {
		int k;
		cin >> ans;
		if (ans == "push") {
			cin >> k;
			s.push(k);
		}
		else if (ans == "pop") {
			if (s.empty() == 1) {
				cout << "-1" << "\n";
			}
			else {
				cout << s.top()<<"\n";
				s.pop();
			}
		}
		else if (ans == "top") {
			if (s.empty() == 1)
				cout << "-1" << "\n";
			else
				cout << s.top() << "\n";
		}
		else if (ans == "size") {
			cout << s.size()<<"\n";
		}
		else if (ans == "empty") {
			cout << s.empty() << "\n";
		}
	}

}