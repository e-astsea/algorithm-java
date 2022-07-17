#include<iostream>
#include <string>

using namespace std;

int main() {

	string quiz;
	int N;
	char arr[80];
	int result = 0;
	int k = 1;
	cin >> N;

	for (int i = 0; i < N; i++) {
		k = 1;

		cin >> quiz;

		for (int j = 0; j < quiz.length(); j++) {
			
			if (quiz.at(j) == 'O') {
				result += k;
				k++;
			}
			else if (quiz.at(j) == 'X')
				k = 1;

		}
		cout << result<<endl;
		result = 0;
	}
	
}