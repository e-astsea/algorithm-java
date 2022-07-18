#include<iostream>
#include <queue>
#include<algorithm>
using namespace std;
int board[52][52];
int visit[52][52];
int main(void) {
	int T, N, M, K,a,b;


	int dx[4] = { 1,0,-1,0 };
	int dy[4] = { 0,1,0,-1 };
	cin >> T;
	for (int i = 0; i < T; i++) {
		cin >> N >> M>>K;
		
			
		for (int i = 0; i < K; i++) {
			cin >> a >> b;
			board[b][a] = 1;
		}

		int num = 0;

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j] == 0 || visit[i][j]==1) continue;
				num++;
				queue<pair<int, int>> Q;
				visit[i][j] == 1;
				
				Q.push({ i,j });


		while (!Q.empty()) {

			pair<int, int> cursor = Q.front();
			Q.pop();
			for (int dir = 0; dir < 4; dir++) {
				int nx = cursor.first + dx[dir];
				int ny = cursor.second + dy[dir];
				if (nx < 0 || ny < 0 || nx >= M|| ny >= N) continue;
				if (board[nx][ny] != 1 || visit[nx][ny] ) continue;
				visit[nx][ny] = 1;
				Q.push({ nx,ny });
			}
		}
			}
		}
		cout << num<<"\n";

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				board[i][j] = 0;
				visit[i][j] = 0;
			}
		}

	}

	
	

}





