#include<iostream>
#include<algorithm>
#include <stack>

using namespace std;

int main(void) {
	int K;
	cin >> K;
	int num;
	int result = 0;
	stack<int> s;
	for (int i = 0; i < K; i++) {
		cin >> num;
		if (num == 0) {
			if (s.empty() == 0)
				result -= s.top();
				s.pop();
		}
		else {
			s.push(num);
			result += num;
		}
	}
	cout << result;


}



